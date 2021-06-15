package projekti.follow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
import projekti.appuser.AppUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "Follows")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Follow extends AbstractPersistable<Long> {

    @OneToOne
    private AppUser follower;

    @OneToOne
    private AppUser followed;

    @Column(name = "startedFollowing")
    private LocalDateTime startedFollowing;
}
