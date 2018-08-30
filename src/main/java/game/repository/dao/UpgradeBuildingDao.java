package game.repository.dao;

import game.model.UpgradeBuildingEntity;
import java.util.List;

public interface UpgradeBuildingDao {

    List<UpgradeBuildingEntity> getUpgradesBuildings(String[] fieldName, Object[] fieldValues);
}
