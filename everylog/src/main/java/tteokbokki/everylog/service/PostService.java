package tteokbokki.everylog.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tteokbokki.everylog.domain.*;

import tteokbokki.everylog.dto.PostDto;
import tteokbokki.everylog.repository.PostRepository;
<<<<<<< HEAD
import java.time.LocalDate;
import java.time.LocalDateTime;
=======

import java.io.IOException;
>>>>>>> 3490e0730a6504d79a69b9347fd56be2b98e7704
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private BaseTimeEntity bte;

    @Transactional
    public Long save(PostDto postDto)
    {
        User user = postDto.getUser();
        if(postDto.getPostType().equals("D")) //다이어리면 addDiary()
        {
            user.addtoday();

            if (user.getLateDate() == null || user.getLateDate() != LocalDate.now()) //오늘 처음 작성
            {
                user.retoday();
                user.addDiary();
                user.updateLateDate(LocalDate.now());
            }}

        return postRepository.save(postDto.toEntity()).getId();

    private final ImageService imageService;

    @Transactional
    public Long save(PostDto postDto) throws IOException {
        List<Image> images = imageService.saveImages(postDto.getImageFiles());
        for (Image image : images) {
            log.info(image.getOriginFilename());
        }
        Post post = postDto.toEntity();
        images.stream()
                .forEach(image -> post.addImage(image));

        return postRepository.save(post).getId();
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

        User user = post.getUser();

        user.subtoday();

        if (user.getTodayDiary() == 0)
            user.subDiary();

        postRepository.delete(post);
        return new PostDto(post);
    }

}
