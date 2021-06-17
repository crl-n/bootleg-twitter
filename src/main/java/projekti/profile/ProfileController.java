package projekti.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import projekti.post.PostService;

@Controller
public class ProfileController {

    @Autowired
    private PostService postService;

    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("posts", postService.getCurrentUsersNewestPosts());
        return "profile";
    }

}
