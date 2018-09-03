package game.service.impl;

import game.dto.CardDto;
import game.dto.CardGroupDto;
import game.dto.CardImpactDto;
import game.model.CardEntity;
import game.model.CardGroupEntity;
import game.model.CardImpactEntity;
import game.repository.dao.CardDao;
import game.service.CardService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class CardServiceImpl implements CardService {

    @Inject
    public CardDao cardDao;

    public List<CardDto> getAllCardList() {
        final List<CardDto> cards = new LinkedList<>();
        cardDao.getAllCardList().forEach(cardEntity -> {
            cards.add(new CardDto(){{
                setId(cardEntity.getId());
                setName(cardEntity.getName());
                setDescription(cardEntity.getDescription());

                CardImpactDto cardImpactDto = getCardImpact(cardEntity.getCardImpactEntity());

                setCardImpactDto(cardImpactDto);
            }});
        });
        return cards;
    }

    private CardImpactDto getCardImpact(CardImpactEntity cardImpactEntity) {
        return new CardImpactDto() {{
            setId(cardImpactEntity.getId());

            CardGroupDto cardGroupDto = getCardGroup(cardImpactEntity.getCardGroupEntity());

            setCardGroupDto(cardGroupDto);

            setP1BuildingAmountMap(cardImpactEntity.getP1BuildingAmountMap());
            setP2BuildingAmountMap(cardImpactEntity.getP2BuildingAmountMap());
            setP1ResourceAmountMap(cardImpactEntity.getP1ResourceAmountMap());
            setP2ResourceAmountMap(cardImpactEntity.getP2ResourceAmountMap());
            setP1UpgradeAmountMap(cardImpactEntity.getP1UpgradeAmountMap());
            setP2UpgradeAmountMap(cardImpactEntity.getP2UpgradeAmountMap());
            setNecessaryBuildingAmountMap(cardImpactEntity.getNecessaryBuildingAmountMap());
            setNecessaryUpgradeAmountMap(cardImpactEntity.getNecessaryUpgradeAmountMap());
        }};
    }

    private CardGroupDto getCardGroup(CardGroupEntity cardGroupEntity) {
        return new CardGroupDto() {{
            setId(cardGroupEntity.getId());
            setName(cardGroupEntity.getName());
            setDescription(cardGroupEntity.getDescription());
        }};
    }
}
