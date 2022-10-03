package tteokbokki.everylog.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "HASHTAG")
@Entity
@Getter
@Setter
public class Hashtag implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post; // 게시글 번호

    @Id
    @Column(name = "hashtag_name")
    private String name; //해시태그 이름
}