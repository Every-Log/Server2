package tteokbokki.everylog.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
@Getter
@NoArgsConstructor
@SuperBuilder
public class StudyPost extends Post{
    //본문 글
    private String StudyContext; //공부 내용
    private String nextStudyContext; //다음에 공부할 내용
    private String weakStudyContext; //부족한 점

    //진도율, 별점
    private float progress; //진도율
    private int StudyStar; //별점

//    @Builder
    public StudyPost(User user, String title, String StudyContext, String nextStudyContext,
                     String weakStudyContext, float progress, int StudyStar) {
        super(user, title);
        this.StudyContext = StudyContext;
        this.nextStudyContext = nextStudyContext;
        this.weakStudyContext = weakStudyContext;
        this.progress = progress;
        this.StudyStar = StudyStar;
    }

    public void update(String title, String StudyContext, String nextStudyContext, String weakStudyContext,
                       float progress, int studyStar) {
        super.update(title);
        this.StudyContext = StudyContext;
        this.nextStudyContext = nextStudyContext;
        this.weakStudyContext = weakStudyContext;
        this.progress = progress;
        this.StudyStar = studyStar;
    }
}
