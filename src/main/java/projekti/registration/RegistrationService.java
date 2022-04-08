package projekti.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import projekti.appuser.AppUser;
import projekti.appuser.AppUserRole;
import projekti.appuser.AppUserService;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {


    private final AppUserService appUserService;

    public String register(RegistrationRequest request) {
        return appUserService
                .signUpUser(new AppUser(request.getUsername(),
                        request.getPassword(),
                        request.getFirstname(),
                        request.getLastname(),
                        request.getPagename(),
                        AppUserRole.USER,
                        LocalDateTime.now()));
    }
}
