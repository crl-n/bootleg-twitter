package projekti.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @GetMapping
    public String register() {
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String firstname,
                           @RequestParam String lastname,
                           @RequestParam String pagename,
                           @RequestParam String password,
                           @RequestParam String rpassword
                           ) {
        RegistrationRequest request = new RegistrationRequest(username, firstname, lastname, pagename, password, rpassword);
        registrationService.register(request);
        return "index";
    }

//    @PostMapping("/register")
//    public String submitRegistration(@ModelAttribute AppUser appUser) {
//        //appUserService.addUser(appUser);
//        return "redirect:/register";
//    }
}
