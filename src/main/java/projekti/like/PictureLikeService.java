package projekti.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekti.appuser.AppUser;
import projekti.appuser.AppUserRepository;
import projekti.picture.Picture;
import projekti.picture.PictureRepository;

@Service
public class PictureLikeService {

    @Autowired
    private PictureLikeRepository pictureLikeRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PictureRepository pictureRepository;

    public void addLike(Long currentUserId, Long pictureId) throws Exception {
        boolean pictureLikeExists = pictureLikeRepository.existsByLikerIdAndPictureId(currentUserId, pictureId);

        if (pictureLikeExists) {
            throw new Exception("Current user already likes this picture.");
        } else {
            boolean appUserExists = appUserRepository.findById(currentUserId).isPresent();
            boolean pictureExists = pictureRepository.findById(pictureId).isPresent();
            if (appUserExists && pictureExists) {
                AppUser appUser = appUserRepository.findById(currentUserId).get();
                Picture picture = pictureRepository.findById(pictureId).get();

                PictureLike pictureLike = new PictureLike();
                pictureLike.setLiker(appUser);
                pictureLike.setPicture(picture);

                // Add pictureLike to picture's list of pictureLikes
                picture.getLikes().add(pictureLike);
                pictureRepository.flush();

                pictureLikeRepository.saveAndFlush(pictureLike);
            }
        }
    }

    public void removeLike(Long currentUserId, Long pictureId) throws Exception {
        boolean pictureLikeExists = pictureLikeRepository.existsByLikerIdAndPictureId(currentUserId, pictureId);

        if (!pictureLikeExists) {
            throw new Exception("Current user does not yet like this picture.");
        } else {
            boolean appUserExists = appUserRepository.findById(currentUserId).isPresent();
            boolean pictureExists = pictureRepository.findById(pictureId).isPresent();
            if (appUserExists && pictureExists) {
                AppUser appUser = appUserRepository.findById(currentUserId).get();
                Picture picture = pictureRepository.findById(pictureId).get();

                // Remove pictureLike from picture's list of pictureLikes
                PictureLike pictureLike = new PictureLike();
                pictureLike.setLiker(appUser);
                pictureLike.setPicture(picture);
                picture.getLikes().remove(pictureLike);
                pictureRepository.flush();

                // Get the id of the persisted pictureLike and use it to delete it from the database
                Long id = pictureLikeRepository.findByLikerIdAndPictureId(currentUserId, pictureId).get().getId();
                pictureLikeRepository.deleteById(id);
                pictureLikeRepository.flush();
            }
        }
    }

    public boolean likeExists(Long currentUserId, Long pictureId) throws Exception {
        return pictureLikeRepository.existsByLikerIdAndPictureId(currentUserId, pictureId);
    }
}
