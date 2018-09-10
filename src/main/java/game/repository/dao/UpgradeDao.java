package game.repository.dao;

import game.model.UpgradeEntity;
import java.util.List;


public interface UpgradeDao {
    List<UpgradeEntity> loadUpgrades(String query);

    List<UpgradeEntity> getUpgrades(String[] fieldName, Object[] fieldValues);

    UpgradeEntity getUpgrade(int id);
}
