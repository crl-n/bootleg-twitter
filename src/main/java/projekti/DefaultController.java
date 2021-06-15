package projekti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import projekti.appuser.AppUserService;

@Controller
public class DefaultController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/frontpage")
    public String landing() {
        return "frontpage";
    }
}
