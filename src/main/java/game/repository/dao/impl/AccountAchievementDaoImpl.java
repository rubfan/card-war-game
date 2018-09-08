package game.repository.dao.impl;

import game.model.AccountAchievementEntity;
import game.repository.dao.AccountAchievementDao;
import game.repository.helper.QueryHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountAchievementDaoImpl implements AccountAchievementDao {

    @Override
    public List<AccountAchievementEntity> getAccountAchievementList(Integer accountId) {
        return new QueryHelper<List<AccountAchievementEntity>>() {

            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<AccountAchievementEntity> accountAchievementEntityList = new ArrayList<>();
                ResultSet resultSet = statement.executeQuery("select * from Account_Achievement where account_id = " + accountId);
                while (resultSet.next()) {
                    AccountAchievementEntity accountAchievementEntity = new AccountAchievementEntity();
                    accountAchievementEntity.setId(resultSet.getInt("id"));
                    accountAchievementEntity.setAccount_id(resultSet.getInt("account_id"));
                    accountAchievementEntity.setAchievement_id(resultSet.getInt("achievement_id"));
                    accountAchievementEntity.setNumber(resultSet.getFloat("number"));
                    accountAchievementEntityList.add(accountAchievementEntity);
                }
                returnResult(accountAchievementEntityList);
            }
        }.run();
    }

    @Override
    public void deleteAccountAchievementList(Integer accountId) {
        new QueryHelper() {
            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                statement.executeUpdate("delete * from Account_Achievement where account_id = " + accountId);
            }
        }.run();
    }

    @Override
    public void updateAccountAchievementList(Integer accountId) {
        new QueryHelper() {
            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                ResultSet resultSet = statement.executeQuery(
                        "select t.achievement_id,\n" +
                                " floor(ifnull(r.number / t.resource_number, 0) - ifnull(a.number, 0)) as resourse_increment,\n" +
                                " floor(ifnull(b.number / t.building_number, 0) - ifnull(a.number, 0)) as building_increment,\n" +
                                " floor(ifnull(u.number / t.upgrade_number, 0) - ifnull(a.number, 0)) as upgrade_increment\n" +
                                " from trigger_achievement t\n" +
                                " left join account_achievement a on t.achievement_id = a.achievement_id and a.account_id = " + accountId +
                                " left join account_resource r on t.resource_id = r.resource_id and r.account_id = " + accountId +
                                " left join account_upgrade u on t.upgrade_id = u.upgrade_id and u.account_id = " + accountId +
                                " left join account_building b on t.building_id = b.building_id and b.account_id = " + accountId +
                                " where ifnull(r.number, 0) >= ifnull(t.resource_number, 0) and\n" +
                                "       ifnull(b.number, 0) >= ifnull(t.building_number, 0) and\n" +
                                "       ifnull(u.number, 0) >= ifnull(t.upgrade_number, 0)"
                );

                while (resultSet.next()) {
                    Integer achievementId = resultSet.getInt("achievement_id");
                    Integer increasingValue = 0;
                    List<Integer> increasingValueList = new ArrayList<>();
                    for (int i = 2; i <= 4; i++) {
                        if (resultSet.getInt(i) > 0) increasingValueList.add(resultSet.getInt(i));
                    }
                    if (!increasingValueList.isEmpty()) {
                        increasingValue = Collections.min(increasingValueList);
                        if (statement.execute(" select * from Account_Achievement where account_id = " + accountId +
                                " and achievement_id = " + achievementId)) {
                            statement.executeUpdate(" update Account_Achievement set number = number + " + increasingValue +
                                    " where account_id = " + accountId + " and achievement_id = " + achievementId);
                        } else {
                            statement.executeUpdate(" insert into Account_Achievement (account_id, achievement_id, number) " +
                                    " values (" + accountId + ", " + achievementId + ", " + increasingValue + ")");
                        }
                    }
                }
            }
        }.run();
    }
}


