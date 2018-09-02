package game.repository.dao.impl;

import game.model.AchievementEntity;
import game.repository.dao.AchievementDao;
import game.repository.helper.QueryHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AchievementDaoImpl implements AchievementDao {

    @Override
    public List<AchievementEntity> getAllAchievementList() {
        return new QueryHelper<List<AchievementEntity>>() {
            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<AchievementEntity> achievementEntityList = new ArrayList<>();
                ResultSet resultSet = statement.executeQuery("select * from Achievement");
                while (resultSet.next()) {
                    AchievementEntity achievementEntity = new AchievementEntity();
                    achievementEntity.setId(resultSet.getInt("id"));
                    achievementEntity.setName(resultSet.getString("name"));
                    achievementEntity.setDescription(resultSet.getString("description"));
                    achievementEntityList.add(achievementEntity);
                }
                returnResult(achievementEntityList);
            }
        }.run();
    }
}
