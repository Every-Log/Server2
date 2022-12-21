package tteokbokki.everylog.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
public class PostHashtag {

    @Id @GeneratedValue
    @Column(name = "post_hashtag_id")
    private Long id;

    // N : 1 (게시글)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    // N : 1 (해시태그)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hashtag_id")
    private Hashtag hashtag;


    protected PostHashtag() {
    }
    public PostHashtag(Long id, Post post, Hashtag hashtag) {
        this.id = id;
        this.post = post;
        this.hashtag = hashtag;
    }

    public PostHashtag(Post post, Hashtag hashtag) {
        this.post = post;
        this.hashtag = hashtag;
    }
    public static PostHashtag of(Post post, Hashtag hashtag) {
        return new PostHashtag(post, hashtag);
    }

}
