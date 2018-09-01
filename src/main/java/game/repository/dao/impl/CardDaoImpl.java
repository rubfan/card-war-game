package game.repository.dao.impl;

import game.model.CardEntity;
import game.model.CardGroupEntity;
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
                        " select c.id, c.name, c.description from Card c"
                );
                while (rs.next()) {
                    CardEntity card = new CardEntity();
                    Integer cardId = rs.getInt("id");

                    card.setId(cardId);
                    card.setName(rs.getString("name"));
                    card.setDescription(rs.getString("description"));
                    card.setCardImpactEntity(getCardImpact(cardId));
                    cards.add(card);
                }
                returnResult(cards);
            }
        }.run();
    }

    private CardImpactEntity getCardImpact(Integer cardId) {

        return new QueryHelper<CardImpactEntity>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                CardImpactEntity cardImpact = new CardImpactEntity();
                cardImpact.setId(cardId);

                ResultSet rs = statement.executeQuery(
                        "select i.card_group_id, " +
                                "i.p1_building_id, i.p2_building_id, " +
                                "i.p1_building_number, i.p2_building_number, " +
                                "i.p1_resource_id, i.p2_resource_id, " +
                                "i.p1_resource_number, i.p2_resource_number, " +
                                "i.p1_upgrade_id, i.p2_upgrade_id, " +
                                "i.p1_upgrade_number, i.p2_upgrade_number, " +
                                "i.necessary_building_id, i.necessary_upgrade_id, " +
                                "i.necessary_building_number, i.necessary_upgrade_number " +
                                "from Card_Impact i " +
                                "where i.card_id= " + cardId.toString()
                );
                boolean id, number;
                while (rs.next()) {
                    Integer p1_building_id = rs.getInt("p1_building_id");
                    id = !rs.wasNull();
                    Float p1_building_number = rs.getFloat("p1_building_number");
                    number = !rs.wasNull();
                    if(id && number) cardImpact.getP1BuildingAmountMap().put(p1_building_id, p1_building_number);

                    Integer p2_building_id = rs.getInt("p2_building_id");
                    id = !rs.wasNull();
                    Float p2_building_number = rs.getFloat("p2_building_number");
                    number = !rs.wasNull();
                    if(id && number) cardImpact.getP2BuildingAmountMap().put(p2_building_id, p2_building_number);

                    Integer p1_resource_id = rs.getInt("p1_resource_id");
                    id = !rs.wasNull();
                    Float p1_resource_number = rs.getFloat("p1_resource_number");
                    number = !rs.wasNull();
                    if(id && number) cardImpact.getP1ResourceAmountMap().put(p1_resource_id, p1_resource_number);

                    Integer p2_resource_id = rs.getInt("p2_resource_id");
                    id = !rs.wasNull();
                    Float p2_resource_number = rs.getFloat("p2_resource_number");
                    number = !rs.wasNull();
                    if(id && number) cardImpact.getP2ResourceAmountMap().put(p2_resource_id, p2_resource_number);

                    Integer p1_upgrade_id = rs.getInt("p1_upgrade_id");
                    id = !rs.wasNull();
                    Float p1_upgrade_number = rs.getFloat("p1_upgrade_number");
                    number = !rs.wasNull();
                    if(id && number) cardImpact.getP2ResourceAmountMap().put(p1_upgrade_id, p1_upgrade_number);

                    Integer p2_upgrade_id = rs.getInt("p2_upgrade_id");
                    id = !rs.wasNull();
                    Float p2_upgrade_number = rs.getFloat("p2_upgrade_number");
                    number = !rs.wasNull();
                    if(id && number) cardImpact.getP2ResourceAmountMap().put(p2_upgrade_id, p2_upgrade_number);

                    Integer necessary_building_id = rs.getInt("necessary_building_id");
                    id = !rs.wasNull();
                    Float necessary_building_number = rs.getFloat("necessary_building_number");
                    number = !rs.wasNull();
                    if(id && number) cardImpact.getP2ResourceAmountMap().put(necessary_building_id, necessary_building_number);

                    Integer necessary_upgrade_id = rs.getInt("necessary_upgrade_id");
                    id = !rs.wasNull();
                    Float necessary_upgrade_number = rs.getFloat("necessary_upgrade_number");
                    number = !rs.wasNull();
                    if(id && number) cardImpact.getP2ResourceAmountMap().put(necessary_upgrade_id, necessary_upgrade_number);
                }

                rs.first();
                Integer groupId = rs.getInt("card_group_id");
                cardImpact.setCardGroupEntity(getCardGroup(groupId));

                returnResult(cardImpact);
            }
        }.run();
    }
    private CardGroupEntity getCardGroup(Integer groupId) {

        return new QueryHelper<CardGroupEntity>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                CardGroupEntity cardGroup = new CardGroupEntity();
                cardGroup.setId(groupId);

                ResultSet rs = statement.executeQuery(
                        "select g.name, g.description " +
                                "from Card_Group g where g.id= " + groupId.toString()
                );
                while (rs.next()) {
                    cardGroup.setName(rs.getString("name"));
                    cardGroup.setDescription(rs.getString("description"));
                }

                returnResult(cardGroup);
            }
        }.run();
    }

}