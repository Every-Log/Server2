package tteokbokki.everylog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tteokbokki.everylog.domain.Post;
import tteokbokki.everylog.domain.PostType;
import tteokbokki.everylog.dto.PostDto;
import tteokbokki.everylog.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostDto postDto){
        return postRepository.save(postDto.toEntity()).getId();
    }

    //조회
    public PostDto findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("이런 게시글은 없습니다. id=" + id));

        return new PostDto(post);
    }

    @Transactional
    public PostDto delete(Long id){
        Post post = postRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("게시물이 없습니다."));
        postRepository.delete(post);
        return new PostDto(post);
    }

    // 카테고리 별 조회
    @Transactional
    public List<PostDto> postList(String postType){
        List<Post> posts = postRepository.findPostByCategory(postType);
        List<PostDto> postDtoList = new ArrayList<>();
        if(posts.isEmpty()) return postDtoList;

        for(Post post : posts){
            postDtoList.add(this.convertEntityToDto(post));
        }
        return postDtoList;
    }

    private PostDto convertEntityToDto(Post post){
        return PostDto.builder().build();
    }

    // 해시태그 검색 조회
    public PostDto search(Long id){
        "SELECT * FROM Post where  "
        return new PostDto(post);
    }

    /*@Repository
    public interface postList extends JpaRepository<Post, Long> {
        @Query("SELECT post" + "FROM ")
    }*/
}
