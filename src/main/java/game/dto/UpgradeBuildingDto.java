package game.dto;

/**
 * @author ruslan.gramatic
 */
public class UpgradeBuildingDto {
    private int id;
    private Integer buildingId;
    private Integer upgradeId;
    private Float percent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getUpgradeId() {
        return upgradeId;
    }

    public void setUpgradeId(Integer upgradeId) {
        this.upgradeId = upgradeId;
    }

    public Float getPercent() {
        return percent;
    }

    public void setPercent(Float percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "UpgradeBuildingDto{" +
                "id=" + id +
                ", buildingId=" + buildingId +
                ", upgradeId=" + upgradeId +
                ", percent=" + percent +
                '}';
    }
}