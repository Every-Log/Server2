package tteokbokki.everylog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tteokbokki.everylog.domain.Post;
import tteokbokki.everylog.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long id);

    // 해시태그 검색
    @Query("SELECT post " +
            "FROM Post post " +
            "WHERE  ")
    List<Post> findPostByHashtag(@Param(""));


    // 카테고리 별 조회
    @Query("SELECT post " +
            "FROM Post post " +
            "WHERE post.dytpe Like CONCAT('%',:catetory,'%') ")
    List<Post> findPostByCategory(@Param(""));

    @Query("SELECT diary_post " +
            "FROM Post diary_post")
    List<Post> findPostByDiary(@Param(""));

}
