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

//    @PostMapping("/api/post/save")
//    public Long save(@RequestBody PostDto postDto) throws IOException {
//        return postService.save(postDto);
//    }

//    @ResponseBody
//    @GetMapping("/images/{filename}")
//    public Resource processImg(@PathVariable String filename) throws MalformedURLException {
//        return new UrlResource("file:" + fileStore.createPath(filename));
//    }


//    @GetMapping("/api/post")
//    public List<Post> getAllPosts() {
//        return (List<Post>) postService.findAll();
//    }
//
//    @GetMapping(value = "", params = {"hashtag"})
//    public String getFilteredPosts(Model model, @RequestParam String hashtag) {
//        model.addAttribute("posts", postService.findAllByHashtag(hashtag));
//        return "post/index";
//    }
//
//    @PostMapping("/api/post")
//    public String createPost(PostSaveRequestDto postSaveRequestDto,
//                             HttpSession httpSession,
//                             @RequestParam(value = "hashtags", defaultValue = "false") List<String> hashtags) {
//        postService.save(postSaveRequestDto, httpSession, hashtags);
//        return "redirect:/posts";
//    }
//
//    @GetMapping("/api/post/{id}")
//    public String getPostDetail(@PathVariable Long id, Model model) throws IOException {
//        postService.increaseViewCount(id);
//        model.addAttribute("post", postService.getPostById(id));
//        model.addAttribute("contents", postService.getHtml(id));
//        return "post/show";
//    }

}
