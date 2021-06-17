package projekti.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
import projekti.appuser.AppUser;
import projekti.post.Post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity(name = "Comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends AbstractPersistable<Long> {

    @ManyToOne
    private AppUser author;

    @ManyToOne
    private Post post;

    @Column(name = "postedAt")
    private LocalDateTime postedAt;

    @Column(name = "content")
    private String content;
}
