package game.repository.dao.impl;

import game.model.AchievementEntity;
import game.repository.dao.AchievementDao;
import game.repository.helper.QueryHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class AchievementDaoImpl implements AchievementDao {

    @Override
    public List<AchievementEntity> getAllAchievementList() {
        return new QueryHelper<List<AchievementEntity>>() {
            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<AchievementEntity> achievementEntityList = new LinkedList<>();
                ResultSet resultSet = statement.executeQuery("select * from Achievement");
                while (resultSet.next()) {
                    AchievementEntity achievementEntity = new AchievementEntity();
                    achievementEntity.setId(resultSet.getInt(1));
                    achievementEntity.setName(resultSet.getString(2));
                    achievementEntity.setDescription(resultSet.getString(3));
                    achievementEntityList.add(achievementEntity);
                }
                returnResult(achievementEntityList);
            }
        }.run();
    }
}
