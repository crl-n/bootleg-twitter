package projekti.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
import projekti.appuser.AppUser;
import projekti.comment.Comment;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "Posts")
@Data
@NoArgsConstructor
public class Post extends AbstractPersistable<Long> {

    @ManyToOne
    private AppUser author;

    @Column(name = "postedAt")
    private LocalDateTime postedAt;

    @OneToMany
    private List<Comment> comments;

    @Column(name = "content")
    private String content;

}
