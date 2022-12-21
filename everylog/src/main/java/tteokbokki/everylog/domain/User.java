package tteokbokki.everylog.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

@Table(name = "MEMBER")
@Entity
@Getter
@NoArgsConstructor
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "member_id")
        private Long id; //회원번호

        @Column(nullable = false, unique = true)
        private String userId; //아이디
        @Column
        private String name; //닉네임
        @Column
        private String password; //비밀번호
        @Column
        private String image; //이미지 주소
        //달성도
        @Column
        private ArrayList<Float> achievementWhole; //누적 달성도

        @Column
        private int diarySum = 0; //이번달 다이어리 글 수

        @Column
        private float achievementmonth = 0.0f; //이번 달 달성도.

        @Column
        private LocalDate lateDate = null;

        private int todayDiary = 0;

        @Builder
        public User(String userId, String name, String password, String image) {
                this.userId = userId;
                this.name = name;
                this.password = password;
                this.image = image;
        }

        public void update(String name, String img)
        {
                this.name = name;
                this.image = img;
        }

        public void retoday(){todayDiary = 1;}
        public int addtoday(){return ++todayDiary;}
        public int subtoday(){return --todayDiary;}
        public int addDiary() {
                ++diarySum;
                computeAchive();
                return diarySum;
        } //다이어리 글 추가
        public int subDiary() {
                --diarySum;
                computeAchive();
                return diarySum;
        } //다이어리 글 감소

        private void computeAchive(){
                Calendar cal = Calendar.getInstance();
                int allDate = cal.getActualMaximum(Calendar.DATE);
                achievementmonth = (diarySum*100)/allDate;
        }

        public void sendAchive(){
                achievementWhole.add(achievementmonth);
                diarySum = 0;
                achievementmonth = 0.0f;
                todayDiary = 0;
        }

        public void updateLateDate(LocalDate ld) { this.lateDate = ld;}

}
