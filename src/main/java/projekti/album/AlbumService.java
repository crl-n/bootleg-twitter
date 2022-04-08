package projekti.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekti.appuser.AppUser;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album createNewAlbum(AppUser appUser) {
        Album album = new Album();
        album.setUser(appUser);
        return albumRepository.saveAndFlush(album);
    }

    public Album getUserAlbum(AppUser user) {
        return albumRepository.findByUser(user);
    }
}
