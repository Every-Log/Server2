package tteokbokki.everylog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tteokbokki.everylog.domain.Hashtag;

@Getter
@Setter
@NoArgsConstructor
public class HashtagDto {

    private String name;
    public Hashtag toEntity(){
        return Hashtag.builder()
                .name(name).build();
    }
}
