package tteokbokki.everylog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tteokbokki.everylog.domain.Post;
import tteokbokki.everylog.domain.User;
import tteokbokki.everylog.dto.PostDto;
import tteokbokki.everylog.dto.UserDto;
import tteokbokki.everylog.repository.PostRepository;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostDto postDto){
        return postRepository.save(postDto.toEntity()).getId();
    }

    //조회
    public Post findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("이런 게시긓은 없습니다. id=" + id));

        return post;
    }

    @Transactional
    public void delete(Long id){
        Post post = postRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("게시물이 없습니다." + id));
        postRepository.delete(post);
    }
}
