package tteokbokki.everylog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "IMAGE")
@Entity
@NoArgsConstructor
@Getter
public class Image {
    @Id
    @GeneratedValue
    @Column(name = "image_id")
    private Long id; // 이미지 번호

    @Column
    private String image; //이미지 주소
}
