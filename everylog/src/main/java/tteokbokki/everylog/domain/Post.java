package tteokbokki.everylog.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "POST")
@Entity
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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

    // N : 1 (카테고리)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_name")
    private Category category; //카테고리

    @Column
    private String title; //제목

    // 1 : N (해시태그)
    @OneToMany(mappedBy = "post")
    private List<Hashtag> hashtags = new ArrayList<>();

    // 1 : N (이미지)
    @OneToMany(mappedBy = "post")
    private List<PostImage> PostImages = new ArrayList<>();

    @Builder
    public Post(Long id, User user, Category category, String title, List<Hashtag> hashtags, List<PostImage> postImages) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.title = title;
        this.hashtags = hashtags;
        PostImages = postImages;
    }
}
