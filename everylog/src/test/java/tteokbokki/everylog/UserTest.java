package tteokbokki.everylog;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tteokbokki.everylog.domain.User;
import tteokbokki.everylog.dto.UserDto;
import tteokbokki.everylog.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class UserTest {

    @Autowired
    UserService userService;

    @Test
    public void login(){
        String s = userService.login("haeji", "01039758088");
        assertEquals("Failed",s, "로그인실패");
    }

    @Test
    public void 회원조회(){
        //이런 정보로 가입했을 때
        User user = new User("1", "name", "pass", "img");
        Long uId = userService.save(new UserDto(user));

        //아이디를 넣고 조회하면
        assertEquals("name", userService.findById(uId).getName(), "그 이름이 아닙니다만..");
        assertEquals("pass", userService.findById(uId).getPassword(), "비밀번호가 달라요");
        assertEquals("img", userService.findById(uId).getImage(), "이미지가 달라요");

    }

    @Test
    public void 회원정보수정(){
        //이런 정보로 가입했을 때
        User user = new User("1", "name", "pass", "img");
        Long uId = userService.save(new UserDto(user));

        //수정해볼게요
        UserDto uD = new UserDto(user);
        uD.update("수정된 name", "수정된 img");
        userService.update(uId, uD);

        //확인
        assertEquals("수정된 name", userService.findById(uId).getName(), "이름이 달라요");
        assertEquals("수정된 img", userService.findById(uId).getImage(), "이미지가 달라요");
    }
}
