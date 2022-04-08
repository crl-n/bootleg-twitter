package projekti.follow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/follow")
    public void follow(@RequestParam Long currentUserId, @RequestParam Long profileUserId) {
        followService.addFollow(currentUserId, profileUserId);
    }

}
