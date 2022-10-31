package tteokbokki.everylog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
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
}
