package tteokbokki.everylog.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Table(name = "POST")
@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
public class Post{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id; //게시글 번호

    // N : 1 (회원)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private User user; //작성 회원

    @Column
    private String title; //제목

    @Column
    private LocalDate date;

    @OneToMany(mappedBy = "post")
    @ToString.Exclude
    @Setter
    private Set<PostHashtag> hashtags = new HashSet<>();

    public String getDiscriminatorValue(){
        DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );

        return val == null ? null : val.value();
    }

    public Post(User user, String title,Set<PostHashtag> hashtags) {
        this.user = user;
        this.title = title;
        this.hashtags = hashtags;
        this.date = LocalDate.now();
    }

    public void update(String title)
    {
        this.title = title;
    }
}
