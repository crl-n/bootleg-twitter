package projekti.like;

import org.springframework.data.jpa.repository.JpaRepository;
import projekti.appuser.AppUser;

import java.util.Optional;

public interface PictureLikeRepository extends JpaRepository<PictureLike, Long> {

    public boolean existsByLiker(AppUser appUser);

    boolean existsByLikerIdAndPictureId(Long currentUserId, Long pictureId);

    Optional<PictureLike> findByLikerIdAndPictureId(Long currentUserId, Long pictureId);
}
