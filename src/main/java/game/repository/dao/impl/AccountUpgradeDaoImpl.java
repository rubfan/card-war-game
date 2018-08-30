package game.repository.dao.impl;

import game.model.AccountUpgradeEntity;
import game.model.UpgradeBuildingEntity;
import game.model.UpgradeEntity;
import game.repository.dao.AccountUpgradeDao;
import game.repository.dao.UpgradeDao;
import game.repository.helper.QueryHelper;
import javax.annotation.Resource;
import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Resource(name = "accountUpgradeDAO")
public class AccountUpgradeDaoImpl implements AccountUpgradeDao {

    @Inject
    UpgradeDao upgradeDao;

    @Override
    public List<AccountUpgradeEntity> loadAccountUpgradeList(String query){
        return  new QueryHelper<List<AccountUpgradeEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                ResultSet rs = statement.executeQuery(query);
                List<AccountUpgradeEntity> accountUpgradeEntityList = new ArrayList<>();
                while(rs.next()) {
                    AccountUpgradeEntity accountUpgradeEntity = new AccountUpgradeEntity();
                    accountUpgradeEntity.setId(rs.getInt("id"));
                    accountUpgradeEntity.setAccountId(rs.getInt("account_id"));
                    accountUpgradeEntity.setUpgradeId(rs.getInt("upgrade_id"));
                    accountUpgradeEntityList.add(accountUpgradeEntity);
                }
                returnResult(accountUpgradeEntityList);
            }
        }.run();
    }

    @Override
    public List<AccountUpgradeEntity> getAccountUpgrades(String[] fieldName, Object[] fieldValues) {
        StringBuilder query = new StringBuilder("select id, account_id, building_upgrade_id from account_upgrade");
        if (fieldName == null)
            return loadAccountUpgradeList(query.toString());
        query.append(" where ");
        for (int i = 0; i < fieldName.length; i++) {
            query.append(fieldName[i] + " = " + fieldValues[i]);
            if (i < fieldName.length - 1) query.append(" and ");
        }
        return loadAccountUpgradeList(query.toString());
    }

    @Override
    public List<UpgradeBuildingEntity> loadUpgradesBuildings(String query){
        return  new QueryHelper<List<UpgradeBuildingEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                ResultSet rs = statement.executeQuery(query);
                List<UpgradeBuildingEntity> upgradeBuildingEntityList = new ArrayList<>();
                while(rs.next()) {
                    UpgradeBuildingEntity upgradeBuildingEntity = new UpgradeBuildingEntity();
                    upgradeBuildingEntity.setId(rs.getInt("id"));
                    upgradeBuildingEntity.setBuildingId(rs.getInt("building_id"));
                    upgradeBuildingEntity.setUpgrageId(rs.getInt("upgrade_id"));
                    upgradeBuildingEntity.setPercent(rs.getInt("percent"));
                    upgradeBuildingEntityList.add(upgradeBuildingEntity);
                }
                returnResult(upgradeBuildingEntityList);
            }
        }.run();
    }

    @Override
    public List<UpgradeBuildingEntity> getUpgradesBuildings(String[] fieldName, Object[] fieldValues) {
        StringBuilder query= new StringBuilder(
                "select upgrade_building.id as id, upgrade_building.upgrade_id as upgrade_id, " +
                "upgrade_building.building_id as building_id, upgrade_building.percent as percent " +
                "from account_upgrade " +
                "join upgrade_building on account_upgrade.upgrade_id = upgrade_building.upgrade_id");
        if (fieldName == null)
            return loadUpgradesBuildings(query.toString());
        query.append(" where ");
        for (int i = 0; i < fieldName.length; i++) {
            query.append(fieldName[i] + " = " + fieldValues[i]);
            if (i < fieldName.length - 1) query.append(" and ");
        }
        return loadUpgradesBuildings(query.toString());
    }

    @Override
    public List<UpgradeEntity> getUpgrades(String[] fieldName, Object[] fieldValues) {
        StringBuilder query= new StringBuilder(
                "select upgrade.id as id, upgrade.name as name, " +
                        "upgrade.description as description " +
                        "from account_upgrade " +
                        "join upgrade on upgrade.id = account_upgrade.upgrade_id");
        if (fieldName == null)
            return upgradeDao.loadUpgrades(query.toString());
        query.append(" where ");
        for (int i = 0; i < fieldName.length; i++) {
            query.append(fieldName[i] + " = " + fieldValues[i]);
            if (i < fieldName.length - 1) query.append(" and ");
        }
        return upgradeDao.loadUpgrades(query.toString());
    }

    @Override
    public void setAccountUpgrade(List<AccountUpgradeEntity> accountUpgradeEntityList){
        new QueryHelper<Void>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
               for (AccountUpgradeEntity accountUpgradeEntity : accountUpgradeEntityList) {
                   int accountId = accountUpgradeEntity.getAccountId();
                   int upgradeId = accountUpgradeEntity.getUpgradeId();
                   String query = String.format("insert into account_upgrade (account_id, upgrade_id) values (%s,%s)",
                           accountId, upgradeId);
                   statement.executeUpdate(query);
               }
            }
        }.run();
    }

    @Override
    public void eraseAccountUpgrade(int accountId){
        new QueryHelper<Void>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                String query = "delete from account_upgrade where account_id = " + accountId;
                statement.executeUpdate(query);
            }
        }.run();
    }



}
