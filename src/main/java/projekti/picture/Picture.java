package projekti.picture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
import projekti.album.Album;
import projekti.like.PictureLike;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Pictures")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Picture extends AbstractPersistable<Long> {

    @Column(name = "description")
    private String description;

    @Lob
    private byte[] content;

    @ManyToOne
    private Album album;

    @OneToMany(mappedBy = "picture", fetch = FetchType.EAGER)
    private List<PictureLike> likes;
}
