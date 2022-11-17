package tteokbokki.everylog.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("T")
@Getter
@NoArgsConstructor
@SuperBuilder
public class TravelPost extends Post {
    private String travelContext; // 여행 내용
    private String travelDate; // 여행 날짜
    private String summary; // 한 줄 정리

//    @Builder
    public TravelPost(User user, String title, String travelContext, String travelDate, String summary) {
        super(user, title);
        this.travelContext = travelContext;
        this.travelDate = travelDate;
        this.summary = summary;
    }
}
