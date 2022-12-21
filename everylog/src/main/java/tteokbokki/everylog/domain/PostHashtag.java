package tteokbokki.everylog.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
public class PostHashtag {

    @Id @GeneratedValue
    @Column(name = "post_hashtag_id")
    private Long id;

    // N : 1 (게시글)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @NonNull
    private Post post;

    // N : 1 (해시태그)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hashtag_id")
    @NonNull
    private Hashtag hashtag;

    public boolean match(String tagName) {
        return this.hashtag.getName().equals(tagName);
    }

}
