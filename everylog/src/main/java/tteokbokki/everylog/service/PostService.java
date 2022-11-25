package tteokbokki.everylog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tteokbokki.everylog.domain.*;
import tteokbokki.everylog.dto.PostDto;
import tteokbokki.everylog.repository.PostRepository;

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

    public void update(Long id, PostDto postDto){
        //게시글 있는지 확인
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("이런 게시글은 없습니다. id=" + id));

        //PostType에 따라서 업데이트 메소드 호출.
        switch (post.getDiscriminatorValue()){
            case "D":
                DiaryPost diary = (DiaryPost) post;
                diary.update(postDto.getTitle(), postDto.getDiaryContext());
                break;

            case "R":
                ReviewPost review = (ReviewPost) post;
                review.update(postDto.getTitle(), postDto.getReviewContent(), postDto.getReviewStar(), postDto.getReviewContext());
                break;
            case "T":
                TravelPost travel = (TravelPost) post;
                travel.update(postDto.getTitle(), postDto.getTravelContext(), postDto.getTravelDate(), postDto.getSummary());
                break;
            case "S":
                StudyPost study = (StudyPost) post;
                study.update(postDto.getTitle(), postDto.getStudyContext(), postDto.getNextStudyContext(), postDto.getWeakStudyContext(),
                        postDto.getProgress(), postDto.getStudyStar());
                break;
        }
    }

    @Transactional
    public PostDto delete(Long id){
        Post post = postRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("게시물이 없습니다."));
        postRepository.delete(post);
        return new PostDto(post);
    }
}
