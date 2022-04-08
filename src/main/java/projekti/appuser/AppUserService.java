package projekti.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import projekti.album.Album;
import projekti.album.AlbumService;

import java.util.List;

@AllArgsConstructor
@Service
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "user with username %s not found";
    private final AppUserRepository appUserRepository;
    private final AlbumService albumService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public List<AppUser> findAllUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username)));
    }

    public String signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository.findByUsername(appUser.getUsername()).isPresent();
        if (userExists) {
            throw new IllegalStateException("Username already taken.");
        }

        // Set password
        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        // Create and set album
        appUserRepository.save(appUser);
        Album album = albumService.createNewAlbum(appUser);
        appUserRepository.findByUsername(appUser.getUsername()).get().setAlbum(album);
        appUserRepository.flush();

        return "";
    }
}
