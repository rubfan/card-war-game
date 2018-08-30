package game.model;

import java.io.Serializable;
import java.util.Map;

public class CardImpactEntity implements Serializable {
    private Integer id;
    private CardGroupEntity cardGroupEntity;
    private Map<Integer, Float> p1BuildingAmountMap;
    private Map<Integer, Float> p2BuildingAmountMap;
    private Map<Integer, Float> p1ResourceAmountMap;
    private Map<Integer, Float> p2ResourceAmountMap;
    private Map<Integer, Float> p1UpgradeAmountMap;
    private Map<Integer, Float> p2UpgradeAmountMap;
    private Map<Integer, Float> necessaryBuildingAmountMap;
    private Map<Integer, Float> necessaryUpgradeAmountMap;

    public CardImpactEntity() {}

    public CardImpactEntity(Integer id, CardGroupEntity cardGroupEntity, Map<Integer, Float> p1BuildingAmountMap, Map<Integer, Float> p2BuildingAmountMap, Map<Integer, Float> p1ResourceAmountMap, Map<Integer, Float> p2ResourceAmountMap, Map<Integer, Float> p1UpgradeAmountMap, Map<Integer, Float> p2UpgradeAmountMap, Map<Integer, Float> necessaryBuildingAmountMap, Map<Integer, Float> necessaryUpgradeAmountMap) {
        this.id = id;
        this.cardGroupEntity = cardGroupEntity;
        this.p1BuildingAmountMap = p1BuildingAmountMap;
        this.p2BuildingAmountMap = p2BuildingAmountMap;
        this.p1ResourceAmountMap = p1ResourceAmountMap;
        this.p2ResourceAmountMap = p2ResourceAmountMap;
        this.p1UpgradeAmountMap = p1UpgradeAmountMap;
        this.p2UpgradeAmountMap = p2UpgradeAmountMap;
        this.necessaryBuildingAmountMap = necessaryBuildingAmountMap;
        this.necessaryUpgradeAmountMap = necessaryUpgradeAmountMap;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CardGroupEntity getCardGroupEntity() {
        return cardGroupEntity;
    }

    public void setCardGroupEntity(CardGroupEntity cardGroupEntity) {
        this.cardGroupEntity = cardGroupEntity;
    }

    public Map<Integer, Float> getP1BuildingAmountMap() {
        return p1BuildingAmountMap;
    }

    public void setP1BuildingAmountMap(Map<Integer, Float> p1BuildingAmountMap) {
        this.p1BuildingAmountMap = p1BuildingAmountMap;
    }

    public Map<Integer, Float> getP2BuildingAmountMap() {
        return p2BuildingAmountMap;
    }

    public void setP2BuildingAmountMap(Map<Integer, Float> p2BuildingAmountMap) {
        this.p2BuildingAmountMap = p2BuildingAmountMap;
    }

    public Map<Integer, Float> getP1ResourceAmountMap() {
        return p1ResourceAmountMap;
    }

    public void setP1ResourceAmountMap(Map<Integer, Float> p1ResourceAmountMap) {
        this.p1ResourceAmountMap = p1ResourceAmountMap;
    }

    public Map<Integer, Float> getP2ResourceAmountMap() {
        return p2ResourceAmountMap;
    }

    public void setP2ResourceAmountMap(Map<Integer, Float> p2ResourceAmountMap) {
        this.p2ResourceAmountMap = p2ResourceAmountMap;
    }

    public Map<Integer, Float> getP1UpgradeAmountMap() {
        return p1UpgradeAmountMap;
    }

    public void setP1UpgradeAmountMap(Map<Integer, Float> p1UpgradeAmountMap) {
        this.p1UpgradeAmountMap = p1UpgradeAmountMap;
    }

    public Map<Integer, Float> getP2UpgradeAmountMap() {
        return p2UpgradeAmountMap;
    }

    public void setP2UpgradeAmountMap(Map<Integer, Float> p2UpgradeAmountMap) {
        this.p2UpgradeAmountMap = p2UpgradeAmountMap;
    }

    public Map<Integer, Float> getNecessaryBuildingAmountMap() {
        return necessaryBuildingAmountMap;
    }

    public void setNecessaryBuildingAmountMap(Map<Integer, Float> necessaryBuildingAmountMap) {
        this.necessaryBuildingAmountMap = necessaryBuildingAmountMap;
    }

    public Map<Integer, Float> getNecessaryUpgradeAmountMap() {
        return necessaryUpgradeAmountMap;
    }

    public void setNecessaryUpgradeAmountMap(Map<Integer, Float> necessaryUpgradeAmountMap) {
        this.necessaryUpgradeAmountMap = necessaryUpgradeAmountMap;
    }

    @Override
    public String toString() {
        return "CardImpactEntity{" +
                "id=" + id +
                ", cardGroupEntity=" + cardGroupEntity +
                ", p1BuildingAmountMap=" + p1BuildingAmountMap +
                ", p2BuildingAmountMap=" + p2BuildingAmountMap +
                ", p1ResourceAmountMap=" + p1ResourceAmountMap +
                ", p2ResourceAmountMap=" + p2ResourceAmountMap +
                ", p1UpgradeAmountMap=" + p1UpgradeAmountMap +
                ", p2UpgradeAmountMap=" + p2UpgradeAmountMap +
                ", necessaryBuildingAmountMap=" + necessaryBuildingAmountMap +
                ", necessaryUpgradeAmountMap=" + necessaryUpgradeAmountMap +
                '}';
    }
}
