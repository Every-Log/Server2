package tteokbokki.everylog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tteokbokki.everylog.domain.*;
import tteokbokki.everylog.dto.PostDto;
import tteokbokki.everylog.dto.UserDto;
import tteokbokki.everylog.repository.PostRepository;
import tteokbokki.everylog.service.PostService;
import tteokbokki.everylog.service.UserService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class PostTest {

    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    @Test
    public void save() {
        User user1 = new User("1", "name", "pass", "img");
        Long uId = userService.save(new UserDto(user1));
        User user2 = userService.findById(uId).toEntity();
        DiaryPost post = new DiaryPost(user2, "test1","다이어리입니다");
        PostDto postDto = new PostDto(post);
        Long pId = postService.save(postDto);
        assertEquals("test1", postService.findById(pId).getTitle(), "error");
    }

    @Test
    public void delete() throws Exception{
        User user1 = new User("2", "name2", "pass2", "img2");
        Long uId = userService.save(new UserDto(user1));
        User user2 = userService.findById(uId).toEntity();
        DiaryPost post = new DiaryPost(user2, "test2", "다이어리입니다2");
        PostDto postDto = new PostDto(post);
        Long pId = postService.save(postDto);
        String title = postService.findById(pId).getTitle();

        PostDto deletedPostDto = postService.delete(pId);
        assertEquals(title, deletedPostDto.toEntity().getTitle(), "error");

//        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
//                () -> postService.delete(130L));
//        assertThat(e.getMessage()).isEqualTo("게시물이 없습니다.");
    }

    @Test

    public void 다이어리수정(){
        //기존 정보
            //작성자
        User user = new User("1", "name", "pass", "img");
        Long uId = userService.save(new UserDto(user));
            //글
        DiaryPost postd = new DiaryPost(user, "다이어리", "멋있는 다이어리");
        Long pIdd = postService.save(new PostDto(postd));

        //중간확인
        assertEquals("다이어리", postService.findById(pIdd).getTitle(), "다이어리 저장 오류");

        //수정했을 때
        PostDto postDto1 = postService.findById(pIdd);
        postDto1.updateDiary("test", "안 멋있는 다이어리");
        postService.update(pIdd, postDto1);

        //테스트
        assertEquals("test", postService.findById(pIdd).getTitle(), "다이어리 오류");
        assertEquals("안 멋있는 다이어리", postService.findById(pIdd).getDiaryContext(), "다이어리 오류");
    }

    @Test
    public void 리뷰수정(){
        //주어짐
        User user = new User("1", "name", "pass", "img");
        Long uId = userService.save(new UserDto(user));
        ReviewPost postr = new ReviewPost(user, "내돈내산", "책", 2, "맘에 안들어");
        Long pIdr = postService.save(new PostDto(postr));

        //저장 확인
        assertEquals("맘에 안들어", postService.findById(pIdr).getReviewContext(), "리뷰 저장 오류");

        //수정함
        PostDto postDto2 = postService.findById(pIdr);
        postDto2.updateReview("내돈내산", "별로야", "책", 3);
        postService.update(pIdr, postDto2);

        //확인
        assertEquals("별로야", postService.findById(pIdr).getReviewContext(), "리뷰 오류");
    }

    @Test
    public void 여행수정()
    {
        //주어짐
        User user = new User("1", "name", "pass", "img");
        Long uId = userService.save(new UserDto(user));
        TravelPost postt = new TravelPost(user, "제주도", "해물탕 최고", "2022.11.25", "맛있다.");
        Long pIdt = postService.save(new PostDto(postt));

        //수정
        PostDto postDto3 = postService.findById(pIdt);
        postDto3.updateTravel("제주도", "생각해보니 해물탕 보다는 대하구이가...", "2022.11.25", "맛있다.");
        postService.update(pIdt, postDto3);

        //확인
        assertEquals("생각해보니 해물탕 보다는 대하구이가...", postService.findById(pIdt).getTravelContext(),"여행 오류");
    }

    @Test
    public void 공부수정(){
        //주어짐
        User user = new User("1", "name", "pass", "img");
        Long uId = userService.save(new UserDto(user));
        StudyPost posts = new StudyPost(user, "공부하기 싫어", "스프링", "스프링2", "자바", 0.01f,
                1);
        Long pIds = postService.save(new PostDto(posts));

        //수정
        PostDto postDto4 = postService.findById(pIds);
        postDto4.updateStudy("공부하기 진짜 싫어", "스프링", "스프링2", "인텔리J", 0.01f,
                2);
        postService.update(pIds, postDto4);

        //확인
        assertEquals(2, postService.findById(pIds).getStudyStar(), "스터디 오류");

}
