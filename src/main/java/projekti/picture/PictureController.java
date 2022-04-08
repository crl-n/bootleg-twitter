package projekti.picture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @PostMapping("/upload")
    public String upload(@RequestParam("picture") MultipartFile picture, @RequestParam("description") String description, @RequestParam("currentUserId") Long id) throws IOException {
        pictureService.savePicture(picture, description, id);
        return "redirect:profile";
    }

    @PostMapping("/set-profile-picture")
    public String setProfilePicture(@RequestParam("profilePictureId") Long pictureId, @RequestParam("currentUserId") Long userId) {
        pictureService.saveProfilePicture(pictureId, userId);
        return "redirect:profile";
    }

    @GetMapping("/img")
    public void image(HttpServletResponse response, @RequestParam Long id) throws IOException {
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        ServletOutputStream stream = response.getOutputStream();
        stream.write(pictureService.getPictureBytes(id));
        stream.close();
    }
}
