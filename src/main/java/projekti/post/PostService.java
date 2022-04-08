package projekti.post;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import projekti.MVCController;
import projekti.appuser.AppUser;
import projekti.appuser.AppUserRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private MVCController mvcController;

    @Autowired
    private AppUserRepository appUserRepository;

    public Object getNewestPosts() {
        Pageable paging = PageRequest.of(0, 25, Sort.by("postedAt").descending());
        return postRepository.findAll(paging);
    }

    public Object getCurrentUsersNewestPosts() throws UsernameNotFoundException {
        boolean userExists = appUserRepository.findByUsername(mvcController.getCurrentUsername()).isPresent();

        if (!userExists) {
            throw new UsernameNotFoundException("Username not found");
        }
        return postRepository.findTop25PostsByAuthorOrderByPostedAtDesc(appUserRepository.findByUsername(mvcController.getCurrentUsername()).get());
    }

    public Object getUsersNewestPosts(String username) throws UsernameNotFoundException {
        boolean userExists = appUserRepository.findByUsername(username).isPresent();

        if (!userExists) {
            throw new UsernameNotFoundException("Username not found");
        }
        return postRepository.findTop25PostsByAuthorOrderByPostedAtDesc(appUserRepository.findByUsername(username).get());
    }

    public void addPost(String content, String username, LocalDateTime postedAt) throws UsernameNotFoundException{
        if (!appUserRepository.findByUsername(username).isPresent()) {
            throw new UsernameNotFoundException("Username not found.");
        }

        Post post = new Post();
        AppUser author = appUserRepository.findByUsername(username).get();

        post.setAuthor(author);
        post.setContent(content);
        post.setPostedAt(postedAt);

        postRepository.saveAndFlush(post);
    }
}
