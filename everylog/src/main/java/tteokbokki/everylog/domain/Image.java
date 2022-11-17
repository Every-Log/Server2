package tteokbokki.everylog.domain;

import lombok.Getter;

import javax.persistence.*;

@Table(name = "IMAGE")
@Entity
@Getter
public class Image {
    @Id
    @GeneratedValue
    @Column(name = "image_id")
    private Long id; // 이미지 번호

    @Column
    private String image; //이미지 주소
}
