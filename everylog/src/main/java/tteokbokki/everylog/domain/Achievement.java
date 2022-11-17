package tteokbokki.everylog.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "ACHIEVEMENT")
@Entity
@Getter
@NoArgsConstructor
public class Achievement extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id; // 기록 번호

    private Long memberId; // 회원번호

    @Column
    private String achievement; // 달성도

    @Builder
    public Achievement(Long memberId, String achievement) {
        this.memberId = memberId;
        this.achievement = achievement;
    }
}
