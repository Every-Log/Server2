package tteokbokki.everylog.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tteokbokki.everylog.dto.PostDto;
import tteokbokki.everylog.dto.UserDto;
import tteokbokki.everylog.service.PostService;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.MalformedURLException;

@RequiredArgsConstructor
@Controller
@Slf4j
public class PostController {
    // 게시글 등록
    // 게시글 삭제

    private final PostService postService;

    @PostMapping("/api/post")
    public Long save(@RequestBody PostDto postDto) throws IOException {
        return postService.save(postDto);
    }

//    @ResponseBody
//    @GetMapping("/images/{filename}")
//    public Resource processImg(@PathVariable String filename) throws MalformedURLException {
//        return new UrlResource("file:" + fileStore.createPath(filename));
//    }

}
