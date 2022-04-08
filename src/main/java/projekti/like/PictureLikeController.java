package projekti.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Map;

@Controller
public class PictureLikeController {

    @Autowired
    private PictureLikeService pictureLikeService;

    @PostMapping("/like-picture")
    public void like(@RequestParam("currentUserId") Long currentUserId,
                     @RequestParam("pictureId") Long pictureId) throws Exception {
        pictureLikeService.addLike(currentUserId, pictureId);
    }

    @PostMapping("/unlike-picture")
    public void unlike(@RequestParam("currentUserId") Long currentUserId,
                       @RequestParam("pictureId") Long pictureId) throws Exception {
        pictureLikeService.removeLike(currentUserId, pictureId);
    }

    @PostMapping(value = "/picture-liked")
    @ResponseBody
    public String likeExists(@RequestParam("currentUserId") Long currentUserId,
                          @RequestParam("pictureId") Long pictureId) throws Exception {
        boolean likeExists = pictureLikeService.likeExists(currentUserId, pictureId);

        if (likeExists) {
            return "{\"status\": true}";
        } else {
            return "{\"status\": false}";
        }
    }

}
