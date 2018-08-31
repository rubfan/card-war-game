package game.repository.dao.impl;

import game.model.CardEntity;
import game.model.CardImpactEntity;
import game.repository.dao.CardDao;
import game.repository.helper.QueryHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class CardDaoImpl implements CardDao {
    public List<CardEntity> getAllCardList() {
        return new QueryHelper<List<CardEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<CardEntity> cards = new LinkedList<>();
                ResultSet rs = statement.executeQuery(
                        "select c.id, c.name, c.description from Card c"
                );
                while(rs.next()) {
                    CardEntity card = new CardEntity();
                    card.setId(rs.getInt("id"));
                    card.setName(rs.getString("name"));
                    card.setDescription(rs.getString("description"));
                    card.setCardImpactEntity(getCardImpact());
                    cards.add(card);
                }
                returnResult(cards);
            }
        }.run();
    }

    private CardImpactEntity getCardImpact() {
        CardImpactEntity cardImpactEntity = new CardImpactEntity();

        return cardImpactEntity;
    }
}
