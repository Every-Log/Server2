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

    // 카테고리 별 조회

    // JpaRepository에서는 By 뒷 부분은 SQL의 where 조건 절에 해당된다.
    // 따라서, Category을 붙여주면 Like 검색이 된다.
    // 카테고리 검색
    List<Post> findByCategory(String postType);
    // 해시태그 검색
    List<Post> findByh(String hashtag);


}
