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
    public DiaryPost(User user, String title, String diaryContext) {
        super(user, title);
        this.diaryContext = diaryContext;
    }
}
