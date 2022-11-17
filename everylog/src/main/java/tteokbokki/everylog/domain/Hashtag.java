package tteokbokki.everylog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "HASHTAG")
@Entity
@NoArgsConstructor
@Getter
public class Hashtag {

    @Id
    @GeneratedValue
    @Column(name = "hashtag_id")
    private Long id; // 해시태그 번호

    @Column
    private String name; //해시태그 이름

}