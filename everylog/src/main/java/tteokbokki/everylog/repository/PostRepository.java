package tteokbokki.everylog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tteokbokki.everylog.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
