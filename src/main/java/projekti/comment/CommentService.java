package projekti.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import projekti.MVCController;
import projekti.appuser.AppUser;
import projekti.appuser.AppUserRepository;
import projekti.post.Post;
import projekti.post.PostRepository;

import java.time.LocalDateTime;

@Service
public class CommentService {

    @Autowired
    private MVCController mvcController;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    public void addComment(String content, Long id) throws UsernameNotFoundException {

        boolean userExists = appUserRepository.findByUsername(mvcController.getCurrentUsername()).isPresent();

        if (userExists) {
            Comment comment = new Comment();
            comment.setContent(content);

            AppUser author = appUserRepository.findByUsername(mvcController.getCurrentUsername()).get();
            comment.setAuthor(author);
            comment.setPostedAt(LocalDateTime.now());

            commentRepository.saveAndFlush(comment);

            Post post = postRepository.getOne(id);
            post.getComments().add(comment);
            postRepository.flush();
        } else {
            throw new UsernameNotFoundException("Username not found.");
        }

    }
}
