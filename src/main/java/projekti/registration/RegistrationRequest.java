package projekti.registration;

import lombok.*;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class RegistrationRequest {

    private final String username;
    private final String firstname;
    private final String lastname;
    private final String pagename;
    private final String password;
    private final String rpassword;
}
