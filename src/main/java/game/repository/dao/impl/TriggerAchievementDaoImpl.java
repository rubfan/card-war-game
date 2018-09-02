package game.repository.dao.impl;

import game.model.TriggerAchievementEntity;
import game.repository.dao.TriggerAchievementDao;
import game.repository.helper.QueryHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TriggerAchievementDaoImpl implements TriggerAchievementDao {
    @Override
    public List<TriggerAchievementEntity> getAllTriggerAchievementList() {
        return new QueryHelper<List<TriggerAchievementEntity>>() {
            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<TriggerAchievementEntity> triggerAchievementEntityList = new ArrayList<>();
                ResultSet resultSet = statement.executeQuery("select * from Trigger_Achievement");
                while (resultSet.next()) {
                    TriggerAchievementEntity triggerAchievementEntity = new TriggerAchievementEntity();
                    triggerAchievementEntity.setId(resultSet.getInt("id"));
                    triggerAchievementEntity.setAchievementId(resultSet.getInt("achievement_id"));
                    triggerAchievementEntity.setBuildingId(resultSet.getInt("building_id"));
                    triggerAchievementEntity.setResourceId(resultSet.getInt("resource_id"));
                    triggerAchievementEntity.setUpgradeId(resultSet.getInt("upgrade_id"));
                    triggerAchievementEntity.setBuildingNumber(resultSet.getInt("building_number"));
                    triggerAchievementEntity.setResourceNumber(resultSet.getInt("resource_number"));
                    triggerAchievementEntity.setUpgradeNumber(resultSet.getInt("upgrade_number"));
                    triggerAchievementEntityList.add(triggerAchievementEntity);
                }
                returnResult(triggerAchievementEntityList);
            }
        }.run();
    }
}
