package tteokbokki.everylog.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder=true)
public class DiaryPost extends Post{
    private String diaryContext; //글 내용

//    @Builder
    public DiaryPost(User user, String title, String diaryContext) {
        super(user, title);
        this.diaryContext = diaryContext;
    }

    public void update(String title, String diaryContext)
    {
        super.update(title);
        this.diaryContext = diaryContext;
    }
}
