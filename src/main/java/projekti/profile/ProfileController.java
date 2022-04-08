package projekti.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import projekti.MVCController;
import projekti.album.AlbumService;
import projekti.appuser.AppUser;
import projekti.appuser.AppUserRepository;
import projekti.appuser.AppUserService;
import projekti.follow.FollowService;
import projekti.post.PostService;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ProfileController {

    @Autowired
    private PostService postService;

    @Autowired
    private MVCController mvcController;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private FollowService followService;

    @Autowired
    private AlbumService albumService;

    @GetMapping("/profiles/{username}")
    public String search(Model model, @PathVariable("username") String username) throws UsernameNotFoundException {
        String currentUsername = mvcController.getCurrentUsername();
        boolean currentUserExists = appUserRepository.findByUsername(currentUsername).isPresent();
        if (!currentUserExists) {
            throw new UsernameNotFoundException("Username not found");
        }
        AppUser currentUser = appUserRepository.findByUsername(currentUsername).get();
        model.addAttribute("currentUserId", currentUser.getId());

        boolean profileUserExists = appUserRepository.findByUsername(username).isPresent();
        if (!profileUserExists) {
            throw new UsernameNotFoundException("Username not found");
        }
        AppUser profileUser = appUserRepository.findByUsername(username).get();
        String fullName = profileUser.getFullName();
        model.addAttribute("profileUserId", profileUser.getId());
        model.addAttribute("profileFullName", fullName);
        model.addAttribute("posts", postService.getUsersNewestPosts(username));
        model.addAttribute("profileUsername", username);
        model.addAttribute("profileUserFollowers", followService.getFollowerCount(profileUser.getId()));
        model.addAttribute("profileUserJoined", profileUser.getJoinedAt());
        model.addAttribute("pictures", albumService.getUserAlbum(profileUser).getPictures());
        return "profile";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        String currentUsername = mvcController.getCurrentUsername();
        AppUser currentUser = appUserRepository.findByUsername(currentUsername).get();
        String fullName = currentUser.getFullName();
        model.addAttribute("currentUserId", currentUser.getId());
        model.addAttribute("profileUserId", currentUser.getId());
        model.addAttribute("profileFullName", fullName);
        model.addAttribute("posts", postService.getCurrentUsersNewestPosts());
        model.addAttribute("profileUsername", currentUsername);
        model.addAttribute("profileUserFollowers", followService.getFollowerCount(currentUser.getId()));
        model.addAttribute("profileUserJoined", currentUser.getJoinedAt());
        model.addAttribute("pictures", currentUser.getAlbum().getPictures());
        return "profile";
    }

}
