package tteokbokki.everylog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tteokbokki.everylog.domain.Hashtag;
import tteokbokki.everylog.domain.Post;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
}
