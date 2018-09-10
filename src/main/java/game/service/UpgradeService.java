package game.service;

import game.dto.UpgradeDto;
import java.util.List;


public interface UpgradeService {

    List<UpgradeDto> getUpgrades(String[] fieldName, Object[] fieldValues);

}
