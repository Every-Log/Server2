package tteokbokki.everylog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tteokbokki.everylog.domain.Post;
import tteokbokki.everylog.domain.User;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long id);
}
