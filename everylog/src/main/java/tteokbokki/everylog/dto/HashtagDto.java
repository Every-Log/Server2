package tteokbokki.everylog.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tteokbokki.everylog.domain.Achievement;
import tteokbokki.everylog.domain.Hashtag;

@Getter
@NoArgsConstructor
public class HashtagDto {
    private Long id; // 해시태그 번호

    private String name; //해시태그 이름

    @Builder
    public HashtagDto(Hashtag hashtag) {
        this.id = hashtag.getId();
        this.name = hashtag.getName();
    }

    public Hashtag toEntity() {
        return Hashtag.builder()
                .id(id)
                .name(name)
                .build();

    }

}
