package projekti.album;


import org.springframework.data.jpa.repository.JpaRepository;
import projekti.appuser.AppUser;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    Album findByUser(AppUser user);

}
