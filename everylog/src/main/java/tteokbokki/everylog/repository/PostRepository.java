package tteokbokki.everylog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tteokbokki.everylog.domain.Hashtag;
import tteokbokki.everylog.domain.Post;
import tteokbokki.everylog.domain.User;

import java.util.List;
import java.util.Optional;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long id);



    @Query("SELECT hashtag FROM Hashtag hashtag ORDER BY hashtag.name")
    @Transactional(readOnly = true)
    List<Hashtag> findHashtags();

    @Query("SELECT hashtag FROM Hashtag hashtag WHERE hashtag.name = ?1")
    Optional<Hashtag> findHashtagByName(String name);


    List<Post> findAll(String postType);
}
