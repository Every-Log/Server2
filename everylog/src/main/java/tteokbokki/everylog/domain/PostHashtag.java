package tteokbokki.everylog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Table(name = "POST_HASHTAG")
@Entity
@NoArgsConstructor
@Getter
public class PostHashtag {

    // 1 : N (게시글)
    @Id
    @OneToMany(mappedBy = "post_id")
    private List<Post> posts = new ArrayList<>();

    // 1 : N (해시태그)
    @Id
    @OneToMany(mappedBy = "hashtag_id")
    private List<Hashtag> hashtags = new ArrayList<>();

}
