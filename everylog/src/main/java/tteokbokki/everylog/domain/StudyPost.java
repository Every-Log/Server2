package tteokbokki.everylog.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
@Getter
public class StudyPost extends Post{
    //본문 글
    private String StudyContext; //공부 내용
    private String nextStudyContext; //다음에 공부할 내용
    private String weakStudyContext; //부족한 점

    //진도율, 별점
    private float progress; //진도율
    private byte StudyStar; //별점

    @Builder
    public StudyPost(User user, Category category, String title, String StudyContext, String nextStudyContext,
                     String weakStudyContext, float progress, byte StudyStar) {
        super(user, category, title);
        this.StudyContext = StudyContext;
        this.nextStudyContext = nextStudyContext;
        this.weakStudyContext = weakStudyContext;
        this.progress = progress;
        this.StudyStar = StudyStar;
    }
}
