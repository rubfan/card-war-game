package game.dto;

import java.util.List;

/**
 * @author ruslan.gramatic
 */
public class UpgradeDto {
    private Integer id;
    private String name;
    private String description;
    private List<UpgradeBuildingDto> upgradeProductList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UpgradeBuildingDto> getUpgradeProductList() {
        return upgradeProductList;
    }

    public void setUpgradeProductList(List<UpgradeBuildingDto> upgradeProductList) {
        this.upgradeProductList = upgradeProductList;
    }

    @Override
    public String toString() {
        return "UpgradeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", upgradeProductList=" + upgradeProductList +
                '}';
    }
}