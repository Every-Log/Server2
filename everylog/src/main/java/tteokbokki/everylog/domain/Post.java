package tteokbokki.everylog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.web.multipart.MultipartFile;
import tteokbokki.everylog.service.ImageService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "POST")
@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id; //게시글 번호

    // N : 1 (회원)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private User user; //작성 회원

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Image> imageFiles = new ArrayList<>();

    @Column
    private String title; //제목

    public String getDiscriminatorValue(){
        DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );

        return val == null ? null : val.value();
    }

    public Post(User user, String title) {
        this.user = user;
        this.title = title;
    }

    public void update(String title)
    {
        this.title = title;
    }
    public void addImage(Image image) {
        this.imageFiles.add(image);

        // 게시글에 파일이 저장되어있지 않은 경우
        if(image.getPost() != this)
            // 파일 저장
            image.setPost(this);
    }

    public List<MultipartFile> getImageList() {
        List<MultipartFile> images = new ArrayList<>();
        images.add((MultipartFile) imageFiles);
        return images;
    }
}
