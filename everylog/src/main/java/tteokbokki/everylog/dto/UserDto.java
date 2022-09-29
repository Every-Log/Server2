package tteokbokki.everylog.dto;

import lombok.Builder;
import tteokbokki.everylog.domain.User;

import java.lang.reflect.Member;

public class UserDto {
    // 회원번호
    // 아이디
    // 닉네임
    // 비밀번호
    // 이미지
    private Long id;
    private String user_id;
    private String nickname;
    private String password;
    private String image;

    @Builder
    public UserDto(Long id, String user_id, String nickname, String password, String image) {
        this.id = id;
        this.user_id = user_id;
        this.nickname = nickname;
        this.password = password;
        this.image = image;
    }

    public User toEntity() {
        return User.builder().build();

    }
}
