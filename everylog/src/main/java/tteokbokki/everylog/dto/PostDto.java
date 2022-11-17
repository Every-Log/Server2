package tteokbokki.everylog.dto;

import lombok.Builder;
import tteokbokki.everylog.domain.*;

public class PostDto {
    // 게시글 번호
    private Long id;
    // 작성 회원
    private User user;
    // 카테고리
    private Category category;
    // 제목
    private String title;
    // 여행 내용
    private String context;
    // 여행 날짜
    private String travelDate;
    // 한 줄 정리
    private String summary;


    @Builder
    public PostDto(Long id, User user, Category category, String title, String context, String travelDate, String summary) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.title = title;
        this.context = context;
        this.travelDate = travelDate;
        this.summary = summary;
    }

    public Post toEntity() {
        return Post.builder()
                .user(user)
                .category(category)
                .title(title)
                .build();
    }
}
