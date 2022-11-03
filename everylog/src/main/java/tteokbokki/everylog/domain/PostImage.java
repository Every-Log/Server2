package tteokbokki.everylog.domain;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "POST_IMAGE")
@Entity
@Getter
public class PostImage implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post; // 게시글 번호

    @Id
    @Column(name = "post_image")
    private String image; //이미지 주소
}
