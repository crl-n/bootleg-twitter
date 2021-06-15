package projekti.album;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
import projekti.picture.Picture;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Albums")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album extends AbstractPersistable<Long> {

    @OneToMany
    private List<Picture> pictures;
}
