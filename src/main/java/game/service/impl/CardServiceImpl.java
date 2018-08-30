package game.service.impl;

import game.dto.CardDto;
import game.repository.dao.CardDao;
import game.service.CardService;

import javax.inject.Inject;
import java.util.List;

public class CardServiceImpl implements CardService {

    @Inject
    public CardDao cardDao;

    public List<CardDto> getCardList() {
        return null;
    }
}
