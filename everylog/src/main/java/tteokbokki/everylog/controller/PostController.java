package tteokbokki.everylog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tteokbokki.everylog.dto.PostDto;
import tteokbokki.everylog.service.PostService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {
    // 게시글 등록
    // 게시글 삭제

    private final PostService postService;

/*    @PostMapping("/api/register")
    public Long save(@RequestBody PostDto postDto){
        return postService.save(postDto);
    }*/

    @DeleteMapping("/api/delete/{id}")
    public PostDto delete(@PathVariable Long id){
        return postService.delete(id);
    }
    // 카테고리 조회 (게시글, 이미지, 해시태그)
    @GetMapping("/api/search/{category_name}")
    public List<PostDto> searchByCategory(@PathVariable("category_name") String category_name){
        // 게시글 리스트
        List<PostDto> postDtoList = postService.postList(category_name);
        return postDtoList;
    }

    // 해시태그로 게시글 검색
    // (게시글 이미지 해시태그)
    @GetMapping("/api/search/{hashtag_name}")
    public List<PostDto> searchByHashtag(@RequestParam("hashtag_name") String hashtag_name){
        List<PostDto> postDtoList = postService.Search(hashtag_name);
        return postDtoList;
    }
}
