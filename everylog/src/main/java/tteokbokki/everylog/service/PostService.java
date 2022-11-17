package tteokbokki.everylog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tteokbokki.everylog.domain.Post;
import tteokbokki.everylog.dto.PostDto;
import tteokbokki.everylog.repository.PostRepository;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostDto travelPostDto){
        return postRepository.save(travelPostDto.toEntity()).getId();
    }

    @Transactional
    public void delete(Long id){
        Post post = postRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("게시물이 없습니다." + id));
        postRepository.delete(post);
    }
}
