package tteokbokki.everylog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tteokbokki.everylog.domain.*;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
    // 작성 회원
    private User user;
    // 게시글 제목
    private String title;

    private String postType;

    // Travel
    // 여행 내용
    private String travelContext;
    // 여행 날짜
    private String travelDate;
    // 한 줄 정리
    private String summary;

    // Diary
    // diary 글 내용
    private String diaryContext;

    // Review
    // 영화 및 독서란
    private String reviewContent;
    // 리뷰 별점
    private int reviewStar;
    // 리뷰 내용
    private String reviewContext;

    //Study
    // 공부 내용
    private String StudyContext;
    // 다음에 공부할 내용
    private String nextStudyContext;
    // 스터디 - 부족한 점
    private String weakStudyContext;
    // 공부 진도율
    private float progress;
    // 공부 별점
    private byte studyStar;

    public Post toEntity() {

        PostType postType = PostType.fromString(this.getPostType());

        switch (postType){
            case Travel:
                return TravelPost.builder()
                        .user(user)
                        .title(title)
                        .travelContext(travelContext)
                        .travelDate(travelDate)
                        .summary(summary)
                        .build();
            case Diary:
                return DiaryPost.builder()
                        .user(user)
                        .title(title)
                        .diaryContext(diaryContext)
                        .build();
            case Review:
                return ReviewPost.builder()
                        .user(user)
                        .title(title)
                        .reviewContent(reviewContent)
                        .reviewStar(reviewStar)
                        .reviewContext(reviewContext)
                        .build();
            case Study:
                return StudyPost.builder()
                        .user(user)
                        .title(title)
                        .StudyContext(StudyContext)
                        .nextStudyContext(nextStudyContext)
                        .weakStudyContext(weakStudyContext)
                        .progress(progress)
                        .StudyStar(studyStar)
                        .build();
        }

        return null;
    }
}
