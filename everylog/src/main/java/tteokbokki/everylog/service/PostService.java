package tteokbokki.everylog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tteokbokki.everylog.domain.*;

import tteokbokki.everylog.dto.PostDto;
import tteokbokki.everylog.repository.PostRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private BaseTimeEntity bte;

    @Transactional
    public Long save(PostDto postDto){
        User user = postDto.getUser();
        if(postDto.getPostType() == "D") //다이어리면 addDiary()
        {
            user.addtoday();

             if (user.getLateDate() == null || user.getLateDate() != LocalDate.now()) //오늘 처음 작성
             {
                 user.retoday();
                user.addDiary();
                user.updateLateDate(LocalDate.now());
             }}

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

        User user = post.getUser();

        user.subtoday();

        if (user.getTodayDiary() == 0)
            user.subDiary();

        postRepository.delete(post);
        return new PostDto(post);
    }

    // 카테고리 별 조회
    @Transactional
    public List<PostDto> postList(String postType){
        List<Post> posts = postRepository.findPostByCategory();
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

    /*@Repository
    public interface postList extends JpaRepository<Post, Long> {
        @Query("SELECT post" + "FROM ")
    }*/
}
