package projekti.like;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
import projekti.appuser.AppUser;
import projekti.picture.Picture;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PictureLikes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PictureLike extends AbstractPersistable<Long> {

    @ManyToOne
    private AppUser liker;

    @ManyToOne
    private Picture picture;
}
