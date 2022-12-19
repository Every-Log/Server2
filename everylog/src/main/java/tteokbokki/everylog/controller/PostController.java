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

    @PostMapping("/api/register")
    public Long save(@RequestBody PostDto postDto){
        return postService.save(postDto);
    }

    /*@DeleteMapping("/api/delete/{id}")
    public void delete(@PathVariable Long id){
        return postService.delete(id);
    }*/

    @GetMapping("/api/search/{category_name}")
    public String searchByCategory(@PathVariable("category_name") String category_name){
        List<PostDto> postDtoList = postService.postList(category_name);
        return postDtoList;
    }


}
