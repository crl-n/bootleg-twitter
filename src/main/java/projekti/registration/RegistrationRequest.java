package projekti.registration;

import lombok.*;

import java.time.LocalDateTime;

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
}
