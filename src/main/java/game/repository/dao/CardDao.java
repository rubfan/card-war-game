package game.repository.dao;

import game.model.CardEntity;

import java.util.List;

public interface CardDao {
    List<CardEntity> getAllCardList();
}
