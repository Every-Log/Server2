package tteokbokki.everylog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tteokbokki.everylog.dto.PostDto;
import tteokbokki.everylog.repository.PostRepository;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostDto postDto){
        return postRepository.save(postDto.toEntity()).getId();
    }

}
