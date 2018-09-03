package game.model;

import java.io.Serializable;

public class CardEntity implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private CardImpactEntity cardImpactEntity;

    public CardEntity() {}

    public CardEntity(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

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

    public CardImpactEntity getCardImpactEntity() {
        return cardImpactEntity;
    }

    public void setCardImpactEntity(CardImpactEntity cardImpactEntity) {
        this.cardImpactEntity = cardImpactEntity;
    }

    @Override
    public String toString() {
        return "CardEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cardImpactEntity=" + cardImpactEntity +
                '}';
    }
}
