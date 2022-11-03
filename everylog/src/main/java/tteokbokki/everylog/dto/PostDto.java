package tteokbokki.everylog.dto;


import lombok.Builder;
import tteokbokki.everylog.domain.*;

import java.util.List;

public class PostDto {

    // 게시글 번호
    private Long id;
    // 작성 회원
    private User user;
    // 카테고리
    private Category category;
    // 제목
    private String title;
    // 해시태그
    private Hashtag hashtags;
    // 이미지
    private PostImage postImages;


    @Builder
    public PostDto(Long id, User user, Category category, String title, Hashtag hashtags, PostImage postImages) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.title = title;
        this.hashtags = hashtags;
        this.postImages = postImages;

    }

    public Post toEntity() {
        return Post.builder()
                .id(id)
                .user(user)
                .category(category)
                .title(title)
                .hashtags(hashtags)
                .postImages(postImages)
                .build();
    }
}
