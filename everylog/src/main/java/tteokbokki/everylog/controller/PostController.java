package tteokbokki.everylog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

//    @PostMapping("")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Long create(
//            @RequestPart(value="image", required=false) List<MultipartFile> files,
//            @RequestPart(value = "requestDto") PostCreateRequestDto requestDto
//    ) throws Exception {
//
//        return PostService.create(requestDto, files);
//    }


}
