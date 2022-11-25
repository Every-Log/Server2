package tteokbokki.everylog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tteokbokki.everylog.domain.DiaryPost;
import tteokbokki.everylog.domain.Post;
import tteokbokki.everylog.domain.User;
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
}
