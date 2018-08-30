package game.controller.impl;

import game.controller.CardController;
import game.dto.CardDto;
import game.service.CardService;

import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("card")
public class CardControllerImpl implements CardController {
    @Inject
    public CardService cardService;

    @Override
    @Path("list")
    public List<CardDto> getAllCardList() {

        List<CardDto> cardList = cardService.getCardList();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, cardList.toString());
        return cardList;
    }
}
