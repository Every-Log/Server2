package tteokbokki.everylog.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tteokbokki.everylog.domain.User;

import java.lang.reflect.Member;

@Getter
@NoArgsConstructor
public class UserDto {
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

    @Builder
    public UserDto(User user) //엔티티 받아서 Dto 생성
    {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.image = user.getImage();
    }

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .name(name)
                .password(password)
                .image(image)
                .build();
    }

    public void update(String name, String img)
    {
        this.name = name;
        this.image = img;
    }
}
