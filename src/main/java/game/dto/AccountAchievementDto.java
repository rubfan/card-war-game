package game.dto;

/**
 * @author ruslan.gramatic
 */

public class AccountAchievementDto {

    private Integer achievementId;
    private Float number;

    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        this.achievementId = achievementId;
    }

    public Float getNumber() {
        return number;
    }

    public void setNumber(Float number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "AccountAchievementDto{" +
                "achievementId=" + achievementId +
                ", number=" + number +
                '}';
    }
}
