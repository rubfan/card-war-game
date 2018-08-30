package game.service.impl;

import game.dto.UpgradeDto;
import game.model.UpgradeEntity;
import game.repository.dao.UpgradeDao;
import game.service.UpgradeBuildingService;
import game.service.UpgradeService;
import javax.inject.Inject;
import java.util.*;


public class UpgradeServiceImpl implements UpgradeService {

    @Inject
    UpgradeDao upgradeDao;

    @Inject
    UpgradeBuildingService upgradeBuildingService;

    @Override
    public List<UpgradeDto> getUpgrades(String[] fieldName, Object[] fieldValues) {
        List<UpgradeEntity> upgradeEntityList = upgradeDao.getUpgrades(fieldName, fieldValues);
        List<UpgradeDto> res = new ArrayList<>();
        for (UpgradeEntity upgradeEntity : upgradeEntityList){
            UpgradeDto upgradeDto = new UpgradeDto();
            upgradeDto.setId(upgradeEntity.getId());
            upgradeDto.setName(upgradeEntity.getName());
            upgradeDto.setDescription(upgradeEntity.getDescription());
            upgradeDto.setUpgradeProductList(
               upgradeBuildingService.getUpgradesBuildings(new String[]{"upgrade_id"}, new Object[]{upgradeEntity.getId()}));
            res.add(upgradeDto);
        }
        return  res;
    }
}
