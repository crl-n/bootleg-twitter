package projekti.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comment")
    public String comment(@RequestParam String content, @RequestParam Long id) {
        commentService.addComment(content, id);
        return "redirect:/frontpage";
    }


}
