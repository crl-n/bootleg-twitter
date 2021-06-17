package projekti.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import projekti.MVCController;
import projekti.appuser.AppUser;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findTop25PostsByAuthorOrderByPostedAtDesc(AppUser currentUser);

}
