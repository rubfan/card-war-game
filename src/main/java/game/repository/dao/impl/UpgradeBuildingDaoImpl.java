package game.repository.dao.impl;

import game.model.UpgradeBuildingEntity;
import game.repository.dao.UpgradeBuildingDao;
import game.repository.helper.QueryHelper;
import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

@Resource(name = "upgradeBuildingDAO")
public class UpgradeBuildingDaoImpl implements UpgradeBuildingDao{

    public List<UpgradeBuildingEntity> LoadUpgradeBuildingList(String query){
        return  new QueryHelper<List<UpgradeBuildingEntity>>() {
             protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                 ResultSet rs = statement.executeQuery(query);
                 List<UpgradeBuildingEntity> upgradeBuildingEntityList = new ArrayList<>();
                 while(rs.next()) {
                    UpgradeBuildingEntity upgradeBuildingEntity = new UpgradeBuildingEntity();
                    upgradeBuildingEntity.setId(rs.getInt("id"));
                    upgradeBuildingEntity.setUpgrageId(rs.getInt("upgrade_id"));
                    upgradeBuildingEntity.setBuildingId(rs.getInt("building_id"));
                    upgradeBuildingEntity.setPercent(rs.getInt("percent"));
                    upgradeBuildingEntityList.add(upgradeBuildingEntity);
                 }
                 returnResult(upgradeBuildingEntityList);
             }
        }.run();


    }

    @Override
    public List<UpgradeBuildingEntity> getUpgradesBuildings(String[] fieldName, Object[] fieldValues){
        StringBuilder query = new StringBuilder("select id, upgrade_id, building_id, percent from upgrade_building");
        if (fieldName == null)
            return LoadUpgradeBuildingList(query.toString());
        query.append(" where ");
        for (int i = 0; i < fieldName.length; i++) {
            query.append(fieldName[i] + " = " + fieldValues[i]);
            if (i < fieldName.length - 1) query.append(" and ");
        }
        return LoadUpgradeBuildingList(query.toString());
    }

}


