package tteokbokki.everylog.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tteokbokki.everylog.domain.*;

@NoArgsConstructor
@Getter
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
    private int studyStar;

    @Builder
    public PostDto(Post post) //엔티티 받아서 Dto 생성
    {
        this.user = post.getUser();
        this.title = post.getTitle();
        this.postType = post.getDiscriminatorValue();
        switch (postType) {
            case "T":
                TravelPost tPost = (TravelPost) post;
                this.travelContext = tPost.getTravelContext();
                this.travelDate = tPost.getTravelDate();
                this.summary = tPost.getSummary();
                break;
            case "D":
                DiaryPost dPost = (DiaryPost) post;
                this.diaryContext = dPost.getDiaryContext();
                break;
            case "R":
                ReviewPost rPost = (ReviewPost) post;
                this.reviewContent = rPost.getReviewContent();
                this.reviewStar = rPost.getReviewStar();;
                this.reviewContext = rPost.getReviewContext();
                break;
            case "S":
                StudyPost sPost = (StudyPost) post;
                this.StudyContext = sPost.getStudyContext();
                this.nextStudyContext = sPost.getNextStudyContext();
                this.weakStudyContext = sPost.getWeakStudyContext();
                this.progress = sPost.getProgress();
                this.studyStar = sPost.getStudyStar();
        }


    }

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

    public static PostDto from(Post entity) {
        return PostDto.builder()
                .id(entity.getId())
                .userAccountDto(UserAccount.UserAccountDto.from(entity.getUserAccount()))
                .title(entity.getTitle())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .createdBy(entity.getCreatedBy())
                .modifiedAt(entity.getModifiedAt())
                .modifiedBy(entity.getModifiedBy())
                .deleted(entity.getDeleted())
                .viewCount(entity.getViewCount())
                .likeCount(entity.getLikeCount())
                .build();
    }

    public void updateDiary(String title, String context)
    {
        this.title = title;
        this.diaryContext = context;
    }

    public void updateReview(String title, String reviewContext, String reviewContent, int reviewStar)
    {
        this.title = title;
        this.reviewContent = reviewContent;
        this.reviewContext = reviewContext;
        this.reviewStar = reviewStar;
    }

    public void updateTravel(String title, String travelContext, String travelDate, String summary)
    {
        this.title = title;
        this.travelContext = travelContext;
        this.travelDate = travelDate;
        this.summary = summary;
    }

    public void updateStudy(String title, String StudyContext, String nextStudyContext, String weakStudyContext,
                            float progress, int studyStar)
    {
        this.title = title;
        this.StudyContext = StudyContext;
        this.nextStudyContext = nextStudyContext;
        this.weakStudyContext = weakStudyContext;
        this.progress = progress;
        this.studyStar = studyStar;
    }
}