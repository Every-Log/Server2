package tteokbokki.everylog.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Table(name = "POST_HASHTAG")
@Entity
@Getter
public class PostHashtag {

    // 1 : N (게시글)
    @OneToMany(mappedBy = "post_id")
    private List<Post> posts = new ArrayList<>();

    // 1 : N (해시태그)
    @OneToMany(mappedBy = "hashtag_id")
    private List<Hashtag> hashtags = new ArrayList<>();

}
