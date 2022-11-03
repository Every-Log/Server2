package tteokbokki.everylog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tteokbokki.everylog.dto.PostDto;
import tteokbokki.everylog.service.PostService;

@RequiredArgsConstructor
@Controller
public class PostController {
    // 게시글 등록
    // 게시글 삭제

    private final PostService postService;

    @PostMapping("/api/post")
    public Long save(@RequestBody PostDto postDto){
        return postService.save(postDto);
    }

    @DeleteMapping("/api/delete/{id}")
    public void delete(@PathVariable Long id){
        postService.delete(id);
    }

}
