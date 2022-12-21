package tteokbokki.everylog.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tteokbokki.everylog.domain.Post;
import tteokbokki.everylog.dto.PostDto;
import tteokbokki.everylog.dto.UserDto;
import tteokbokki.everylog.service.PostService;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@RequiredArgsConstructor
@Controller
@Slf4j
public class PostController {
    // 게시글 등록
    // 게시글 삭제

    private final PostService postService;

//    @ResponseBody
//    @GetMapping("/images/{filename}")
//    public Resource processImg(@PathVariable String filename) throws MalformedURLException {
//        return new UrlResource("file:" + fileStore.createPath(filename));
//    }


    @GetMapping("/api/post")
    public List<Post> getAllPosts() {
        return (List<Post>) postService.findAll();
    }

//    @GetMapping(value = "/api/post", params = {"hashtag"})
//    public List<Post> getHashtagFilteredPosts(String hashtag) {
//        return (List<Post>) postService.findAllByHashtag(hashtag);
//    }
//
    @PostMapping("/api/post/save")
    public Long savePost(@RequestBody PostDto postDto, List<String> hashtags) throws IOException {
        return postService.save(postDto, hashtags);
    }

    @GetMapping("/api/post/{id}")
    public PostDto getPostDetail(@PathVariable Long id) throws IOException {
        PostDto postDto = postService.findById(id);
        return postDto;
    }

}
