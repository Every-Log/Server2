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

    // 카테고리별 게시글 조회
    @GetMapping("/api/post/{postType}")
    public List<PostDto> getCategoryPosts(@PathVariable("postType") String postType){
        // 게시글 리스트
        List<PostDto> postCategoryList = postService.postList(postType);
        return postCategoryList;
    }

    // 해시태그로 게시글 검색
    // (게시글 이미지 해시태그)
    @GetMapping("/api/search")
    public List<Post> searchByHashtag(@RequestParam("hashtag_name") String hashtag_name){
        List<Post> postHashtagList = (List<Post>)postService.findAllByHashtag(hashtag_name);
        return postHashtagList;
    }

    // 게시글 수정 update
    @GetMapping("/api/post/update/{id}")
    public void updatePost(@PathVariable("id") Long id, @RequestBody PostDto postDto){
        postService.update(id, postDto);
    }

    // 게시글 삭제 delete
    @DeleteMapping("/api/post/{id}")
    public void delete(@PathVariable Long id){
        postService.delete(id);
    }


}
