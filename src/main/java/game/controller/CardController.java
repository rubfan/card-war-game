package game.controller;

import game.dto.CardDto;

import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface CardController {
    List<CardDto> getAllCardList();
}
