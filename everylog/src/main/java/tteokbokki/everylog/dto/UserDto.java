package tteokbokki.everylog.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tteokbokki.everylog.domain.User;

import java.lang.reflect.Member;

@Getter
@NoArgsConstructor
public class UserDto {
    private String user_id; //id
    private String name; //닉네임
    private String password; //비밀번호
    private String image; //이미지

    @Builder
    public UserDto(String user_id, String name, String password, String image) {
        this.user_id = user_id;
        this.name = name;
        this.password = password;
        this.image = image;
    }

    @Builder
    public UserDto(User user) //엔티티 받아서 Dto 생성
    {
        this.user_id = user.getUser_id();
        this.name = user.getName();
        this.password = user.getPassword();
        this.image = user.getImage();
    }

    public User toEntity() {
        return User.builder()
                .user_id(user_id)
                .name(name)
                .password(password)
                .image(image)
                .build();

    }
}
