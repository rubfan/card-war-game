package game.repository.dao.impl;

import game.model.AccountAchievementEntity;
import game.repository.dao.AccountAchievementDao;
import game.repository.helper.QueryHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

            }
        }.run();
    }
}

//                if (statement.execute("select * from Account_Achievement where account_id = " + accountId +
//                "and achievement_id = " + achievementId)){
//                    statement.executeUpdate("update Account_Achievement set number = number + 1 where " +
//                            "account_id = " + accountId + "and achievement_id = " + achievementId);
//                }else {
//                    statement.executeUpdate("insert into Account_Achievement (account_id, achievement_id, number) " +
//                            "values (" + accountId + ", " + achievementId + ", " + 1 + ")");
//                }