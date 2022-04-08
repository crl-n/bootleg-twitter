package projekti.picture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import projekti.album.Album;
import projekti.album.AlbumRepository;
import projekti.appuser.AppUser;
import projekti.appuser.AppUserRepository;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    public void savePicture(MultipartFile imageFile, String description, Long id) throws IOException {
        Picture picture = new Picture();
        AppUser user = appUserRepository.findById(id).get();
        Album album = albumRepository.findByUser(user);

        picture.setContent(imageFile.getBytes());
        picture.setDescription(description);
        picture.setAlbum(album);
        picture.setLikes(new ArrayList<>());
        pictureRepository.saveAndFlush(picture);

        album.getPictures().add(picture);
        albumRepository.flush();
    }

    public void saveProfilePicture(Long pictureId, Long userId) {
        AppUser appUser = appUserRepository.findById(userId).get();
        Picture picture = pictureRepository.findById(pictureId).get();

        //appUser.setProfilePicture(picture);
    }

    public byte[] getPictureBytes(Long id) {
        return pictureRepository.findById(id).get().getContent();
    }
}
