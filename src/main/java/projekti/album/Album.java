package projekti.album;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
import projekti.appuser.AppUser;
import projekti.picture.Picture;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Albums")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album extends AbstractPersistable<Long> {

    @OneToOne
    private AppUser user;

    @OneToMany(mappedBy = "album", fetch = FetchType.EAGER)
    private List<Picture> pictures;
}
