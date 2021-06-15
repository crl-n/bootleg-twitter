package projekti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import projekti.appuser.AppUserService;

@Controller
public class SearchController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/profiles/{username}")
    public String search(Model model, @PathVariable("username") String username) {
        model.addAttribute("results", appUserService.loadUserByUsername(username));
        return "profile";
    }

}
