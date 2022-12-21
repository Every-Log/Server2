//package tteokbokki.everylog.dto;
//
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import tteokbokki.everylog.domain.Achievement;
//import tteokbokki.everylog.domain.User;
//
//@Getter
//@NoArgsConstructor
//public class AchievementDto {
//    private Long memberId;
//    private String achievement;
//
//    @Builder
//    public AchievementDto(Long memberId, String achievement) {
//        this.memberId = memberId;
//        this.achievement = achievement;
//    }
//
//    @Builder
//    public AchievementDto(Achievement achievement) //엔티티 받아서 Dto 생성
//    {
//        this.memberId = achievement.getMemberId();
//        this.achievement = achievement.getAchievement();
//    }
//
//    public Achievement toEntity() {
//        return Achievement.builder()
//                .memberId(memberId)
//                .achievement(achievement)
//                .build();
//
//    }
//}
