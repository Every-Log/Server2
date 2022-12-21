package tteokbokki.everylog.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@SuperBuilder
public class Hashtag {

    @Id
    @GeneratedValue
    @Column(name = "hashtag_id")
    private Long id; // 해시태그 번호

    private String name; //해시태그 이름

    @OneToMany(mappedBy = "hashtag")
    @ToString.Exclude
    private Set<PostHashtag> posts = new HashSet<>();


}