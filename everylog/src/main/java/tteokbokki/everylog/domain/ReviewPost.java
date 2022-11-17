package tteokbokki.everylog.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
@Getter
public class ReviewPost extends Post{
    private String reviewContent; // 영화 및 독서란
    private int reviewStar; // 별점
    private String reviewContext; // 내용

    @Builder
    public ReviewPost(User user,String title, String reviewContent, int reviewStar, String reviewContext) {
        super(user, title);
        this.reviewContent = reviewContent;
        this.reviewStar = reviewStar;
        this.reviewContext = reviewContext;
    }
}
