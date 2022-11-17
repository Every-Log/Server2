package tteokbokki.everylog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "POST_IMAGE")
@Entity
@NoArgsConstructor
@Getter
public class PostImage implements Serializable {

    // 1 : N (게시글)
    @Id
    @OneToMany(mappedBy = "post_id")
    private List<Post> posts = new ArrayList<>();

    // 1 : N (이미지)
    @Id
    @OneToMany(mappedBy = "image_id")
    private List<Image> images = new ArrayList<>();

}
