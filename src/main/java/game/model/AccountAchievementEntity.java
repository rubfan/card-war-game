package game.model;

public class AccountAchievementEntity {
    private Integer id;
    private Integer account_id;
    private Integer achievement_id;

    public AccountAchievementEntity(Integer id, Integer account_id, Integer achievement_id) {
        this.id = id;
        this.account_id = account_id;
        this.achievement_id = achievement_id;
    }

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

    @Override
    public String toString() {
        return "AccountAchievementEntity{" +
                "id=" + id +
                ", account_id=" + account_id +
                ", achievement_id=" + achievement_id +
                '}';
    }
}
