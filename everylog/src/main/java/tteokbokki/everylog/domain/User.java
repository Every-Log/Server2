package tteokbokki.everylog.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "MEMBER")
@Entity
@Getter
@NoArgsConstructor
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "member_id")
        private Long id; //회원번호

        @Column(nullable = false, unique = true)
        private String user_id; //아이디

        @Column
        private String name; //닉네임

        @Column
        private String password; //비밀번호

        @Column
        private String image; //이미지 주소

        @Builder
        public User(String user_id, String name, String password, String image) {
                this.user_id = user_id;
                this.name = name;
                this.password = password;
                this.image = image;
        }

        public void update(String user_id, String name, String password, String image)
        {
                this.user_id = user_id;
                this.name = name;
                this.password = password;
                this.image = image;
        }

}
