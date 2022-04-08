package projekti.follow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekti.appuser.AppUser;
import projekti.appuser.AppUserRepository;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    public void addFollow(Long currentUserId, Long profileUserId) {
        Follow follow = new Follow();
        AppUser followed = appUserRepository.getOne(profileUserId);
        AppUser follower = appUserRepository.getOne(currentUserId);
        follow.setFollowed(followed);
        follow.setFollower(follower);
        followRepository.saveAndFlush(follow);
    }

    public long getFollowerCount(Long id) {
        return followRepository.countByFollowedId(id);
    }
}
