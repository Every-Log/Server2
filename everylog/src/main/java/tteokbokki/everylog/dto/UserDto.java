package tteokbokki.everylog.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tteokbokki.everylog.domain.User;

import java.lang.reflect.Member;

@Getter
@NoArgsConstructor
public class UserDto {
    // 아이디
    // 닉네임
    // 비밀번호
    // 이미지
    private String userId;
    private String name;
    private String password;
    private String image;

    @Builder
    public UserDto(String userId, String name, String password, String image) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.image = image;
    }

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .name(name)
                .password(password)
                .image(image)
                .build();

    }
}
