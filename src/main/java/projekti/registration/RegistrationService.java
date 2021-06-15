package projekti.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import projekti.appuser.AppUser;
import projekti.appuser.AppUserRole;
import projekti.appuser.AppUserService;

@Service
@AllArgsConstructor
public class RegistrationService {


    private final AppUserService appUserService;

    public String register(RegistrationRequest request) {
        return appUserService.signUpUser(new AppUser(request.getUsername(), request.getPassword(), AppUserRole.USER));
    }
}
