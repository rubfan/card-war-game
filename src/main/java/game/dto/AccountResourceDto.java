package game.dto;

/**
 * @author evgen.Kaliba
 */
public class AccountResourceDto {
    private Integer resourceId;
    private Float amount;
    private Float numPerMin;

    @Override
    public String toString() {
        return "AccountResourceDto{" +
                "resourceId=" + resourceId +
                ", amount=" + amount +
                ", numPerMin=" + numPerMin +
                '}';
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getNumPerMin() {
        return numPerMin;
    }

    public void setNumPerMin(Integer numPerMin) {
        this.numPerMin = numPerMin;
    }
}
