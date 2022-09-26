package tteokbokki.everylog.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Member;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberUDto {
    private Long number;
    private String id;
    private String name;
    private String password;
    private String image;

    /* DTO -> Entity */
    public Member toEntity() {
        Member member = Member.builder()
                .number(number)
                .id(id)
                .name(name)
                .password(password)
                .image(image)
                .build();
        return member;
    }

