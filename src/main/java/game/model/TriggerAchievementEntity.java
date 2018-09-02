package game.model;

public class TriggerAchievementEntity {
    private Integer id;
    private Integer achievementId;
    private Integer buildingId;
    private Integer resourceId;
    private Integer upgradeId;
    private Integer buildingNumber;
    private Integer resourceNumber;
    private Integer upgradeNumber;

    public TriggerAchievementEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        this.achievementId = achievementId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getUpgradeId() {
        return upgradeId;
    }

    public void setUpgradeId(Integer upgradeId) {
        this.upgradeId = upgradeId;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Integer getResourceNumber() {
        return resourceNumber;
    }

    public void setResourceNumber(Integer resourceNumber) {
        this.resourceNumber = resourceNumber;
    }

    public Integer getUpgradeNumber() {
        return upgradeNumber;
    }

    public void setUpgradeNumber(Integer upgradeNumber) {
        this.upgradeNumber = upgradeNumber;
    }

    @Override
    public String toString() {
        return "TriggerAchievementEntity{" +
                "id=" + id +
                ", achievementId=" + achievementId +
                ", buildingId=" + buildingId +
                ", resourceId=" + resourceId +
                ", upgradeId=" + upgradeId +
                ", buildingNumber=" + buildingNumber +
                ", resourceNumber=" + resourceNumber +
                ", upgradeNumber=" + upgradeNumber +
                '}';
    }
}
