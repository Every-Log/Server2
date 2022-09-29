package tteokbokki.everylog.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "MEMBER")
@Entity
@Getter
public class member {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "member_id")
        private Long number; //회원번호

        @Column(nullable = false, unique = true)
        private String id; //아이디

        @Column
        private String name; //닉네임

        @Column
        private String password; //비밀번호

        @Column
        private String image; //이미지 주소
}
