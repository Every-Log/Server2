package tteokbokki.everylog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tteokbokki.everylog.domain.User;
import tteokbokki.everylog.dto.PostDto;
import tteokbokki.everylog.dto.UserDto;
import tteokbokki.everylog.service.PostService;
import tteokbokki.everylog.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        PostDto postDto = new PostDto();
        postDto.setUser(user2);
        postDto.setTitle("test1");
        postDto.setPostType("D");
        postDto.setDiaryContext("다이어리입니다");
        Long pId = postService.save(postDto);
        assertEquals("test1", postService.findById(pId).getTitle(), "error");
    }
}
