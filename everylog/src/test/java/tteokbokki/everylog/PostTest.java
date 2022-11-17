package tteokbokki.everylog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tteokbokki.everylog.domain.User;
import tteokbokki.everylog.dto.PostDto;
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
    public void 게시글_등록() {
        User user = userService.findById(1L).toEntity();
        PostDto postDto = new PostDto();
        postDto.setUser(user);
        postDto.setTitle("test1");
        postDto.setPostType("D");
        postDto.setDiaryContext("다이어리입니다");
        Long pId = postService.save(postDto);
        assertEquals("test1", postService.findById(pId).getTitle(), "error");
    }
}
