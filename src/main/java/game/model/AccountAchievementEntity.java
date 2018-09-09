package game.model;

import java.io.Serializable;

/**
 * @author alexey.kostash
 */

public class AccountAchievementEntity implements Serializable {
    private Integer id;
    private Integer account_id;
    private Integer achievement_id;
    private Float number;

    public AccountAchievementEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public Integer getAchievement_id() {
        return achievement_id;
    }

    public void setAchievement_id(Integer achievement_id) {
        this.achievement_id = achievement_id;
    }

    public Float getNumber() {
        return number;
    }

    public void setNumber(Float number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "AccountAchievementEntity{" +
                "id=" + id +
                ", account_id=" + account_id +
                ", achievement_id=" + achievement_id +
                ", number=" + number +
                '}';
    }
}
