package tteokbokki.everylog.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class PostImage {

    @Id @GeneratedValue
    @Column(name = "post_image_id")
    private Long id;

    // N : 1 (게시글)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    // 1 : N(이미지)
    @OneToMany
    //@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private List<Image> image;

}
