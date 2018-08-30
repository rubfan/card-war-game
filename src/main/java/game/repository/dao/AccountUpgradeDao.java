package game.repository.dao;

import game.model.AccountUpgradeEntity;
import game.model.UpgradeBuildingEntity;
import game.model.UpgradeEntity;

import java.util.List;

public interface AccountUpgradeDao {
    List<AccountUpgradeEntity> loadAccountUpgradeList(String query);

    List<AccountUpgradeEntity> getAccountUpgrades(String[] fieldName, Object[] fieldValues);

    List<UpgradeEntity> getUpgrades(String[] fieldName, Object[] fieldValues);

    List<UpgradeBuildingEntity> loadUpgradesBuildings(String query);

    List<UpgradeBuildingEntity> getUpgradesBuildings(String[] fieldName, Object[] fieldValues);

    void setAccountUpgrade(List<AccountUpgradeEntity> accountUpgradeEntityList);

    void eraseAccountUpgrade(int accountId);
}
