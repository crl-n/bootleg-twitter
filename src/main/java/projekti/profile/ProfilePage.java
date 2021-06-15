package projekti.profile;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
import projekti.post.Post;
import projekti.appuser.AppUser;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "ProfilePages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfilePage extends AbstractPersistable<Long> {

    @OneToOne
    private AppUser appUser;

    @OneToMany
    private List<Post> posts;


}
