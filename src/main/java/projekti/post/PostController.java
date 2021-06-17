package projekti.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projekti.MVCController;
import java.time.LocalDateTime;

@Controller
public class PostController {

    @Autowired
    MVCController mvcController;

    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public String post(@RequestParam String content) {
        String author = mvcController.getCurrentUsername();
        LocalDateTime postedAt = LocalDateTime.now();
        postService.addPost(content, author, postedAt);
        return "redirect:/frontpage";
    }
}
