package game.repository.dao;

import game.model.AccountUpgradeEntity;
import game.model.UpgradeBuildingEntity;
import game.model.UpgradeEntity;

import java.util.List;
import java.util.Map;

public interface AccountUpgradeDao {
    List<AccountUpgradeEntity> loadAccountUpgradeList(String query);

    List<AccountUpgradeEntity> getAccountUpgrades(String[] fieldName, Object[] fieldValues);

    Map<UpgradeEntity, Integer> loadUpgrades(String query);

    Map<UpgradeEntity, Integer> getUpgrades(String[] fieldName, Object[] fieldValues);

    Map<UpgradeBuildingEntity, Integer> loadUpgradesBuildings(String query);

    Map<UpgradeBuildingEntity, Integer> getUpgradesBuildings(String[] fieldName, Object[] fieldValues);

    void setAccountUpgrade(List<AccountUpgradeEntity> accountUpgradeEntityList);

    void eraseAccountUpgrade(int accountId);
}
