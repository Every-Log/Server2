package tteokbokki.everylog.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
@Getter
public class DiaryPost extends Post{
    private String diaryContext; //글 내용

    @Builder
    public DiaryPost(User user, Category category, String title, String diaryContext) {
        super(user, category, title);
        this.diaryContext = diaryContext;
    }
}
