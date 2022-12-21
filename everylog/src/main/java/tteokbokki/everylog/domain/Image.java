package tteokbokki.everylog.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long id;

    private String originFilename;

    private String storeFilename;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    // Post 정보 저장
    public void setPost(Post post){
        this.post = post;

        // 게시글에 현재 파일이 존재하지 않는다면
        if(!post.getImageFiles().contains(this))
            // 파일 추가
            post.getImageFiles().add(this);
    }

    @Builder
    public Image(Long id, String originFileName, String storePath) {
        this.id = id;
        this.originFilename = originFileName;
        this.storeFilename = storePath;
    }
}
