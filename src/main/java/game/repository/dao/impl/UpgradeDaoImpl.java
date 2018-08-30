package game.repository.dao.impl;

import game.model.UpgradeEntity;
import game.repository.dao.UpgradeDao;
import game.repository.helper.QueryHelper;
import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

@Resource(name = "upgradeDAO")
public class UpgradeDaoImpl implements  UpgradeDao{

    @Override
    public List<UpgradeEntity> loadUpgrades(String query){
        return new QueryHelper<List<UpgradeEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                ResultSet rs = statement.executeQuery(query);
                List<UpgradeEntity> upgradeEntityList = new ArrayList<>();
                while(rs.next()) {
                    UpgradeEntity upgradeEntity = new UpgradeEntity();
                    upgradeEntity.setId(rs.getInt("id"));
                    upgradeEntity.setName(rs.getString("name"));
                    upgradeEntity.setDescription(rs.getString("description"));
                    upgradeEntityList.add(upgradeEntity);
                }
                returnResult(upgradeEntityList);
            }
        }.run();

    }

    @Override
    public List<UpgradeEntity> getUpgrades(String[] fieldName, Object[] fieldValues){
        StringBuilder query = new StringBuilder("select id, name, description from upgrade");
        if (fieldName == null)
            return loadUpgrades(query.toString());
        query.append(" where ");
        for (int i = 0; i < fieldName.length; i++) {
            query.append(fieldName[i] + " = " + fieldValues[i]);
            if (i < fieldName.length - 1) query.append(" and ");
        }
        return loadUpgrades(query.toString());
    }

    @Override
    public UpgradeEntity getUpgrade(int id){
        List<UpgradeEntity> upgradeEntityList = getUpgrades(new String[]{"id"}, new Object[]{id});
        if (upgradeEntityList.size() == 0) return null;
        return  upgradeEntityList.get(0);
    }
}

