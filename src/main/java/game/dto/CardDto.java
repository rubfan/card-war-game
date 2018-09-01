package game.dto;

/**
 * @author ruslan.gramatic
 */
public class CardDto {
    private Integer id;
    private String name;
    private String description;
    private CardImpactDto cardImpactDto;

    public CardDto() {}

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

    public CardImpactDto getCardImpactDto() {
        return cardImpactDto;
    }

    public void setCardImpactDto(CardImpactDto cardImpactDto) {
        this.cardImpactDto = cardImpactDto;
    }

    @Override
    public String toString() {
        return "CardDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cardImpactDto=" + cardImpactDto +
                '}';
    }
}
