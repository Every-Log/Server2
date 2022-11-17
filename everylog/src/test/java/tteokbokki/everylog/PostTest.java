package tteokbokki.everylog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tteokbokki.everylog.service.PostService;

@SpringBootTest
@Transactional
public class PostTest {

    @Autowired
    PostService postService;
}
