package game.service;

import game.dto.UpgradeBuildingDto;
import java.util.List;


public interface UpgradeBuildingService {

    List<UpgradeBuildingDto> getUpgradesBuildings(String[] fieldName, Object[] fieldValues);

}
