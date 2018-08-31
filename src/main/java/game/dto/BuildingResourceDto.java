<<<<<<< HEAD
package game.dto;

/**
 * @author ruslan.gramatic
 */
public class BuildingResourceDto {
    private Integer resourceId;
    private Float numPerMin;
}
=======
package game.dto;

/**
 * @author ruslan.gramatic
 */
public class BuildingResourceDto {
    private Integer resourceId;
    private Float numPerMin;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Float getNumPerMin() {
        return numPerMin;
    }

    public void setNumPerMin(Float numPerMin) {
        this.numPerMin = numPerMin;
    }

    @Override
    public String toString() {
        return "BuildingResourceDto{" +
                "resourceId=" + resourceId +
                ", numPerMin=" + numPerMin +
                '}';
    }
}
>>>>>>> 91d6f6686cd30cb97a1f73b6f5c03600d5adbc0f
