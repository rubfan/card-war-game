package game.model;

public class UpgradeBuildingEntity {

    private int id;
    private int upgradeId;
    private int buildingId;
    private float percent;

    public UpgradeBuildingEntity(int id, int upgrageId, int buildingId, float percent) {
        this.id = id;
        this.upgradeId = upgrageId;
        this.buildingId = buildingId;
        this.percent = percent;
    }

    public UpgradeBuildingEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUpgrageId() {
        return upgradeId;
    }

    public void setUpgrageId(int upgrageId) {
        this.upgradeId = upgrageId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "UpgradeBuildingEntity{" +
                "id=" + id +
                ", upgrageId=" + upgradeId +
                ", buildingId=" + buildingId +
                ", percent=" + percent +
                '}';
    }
}
