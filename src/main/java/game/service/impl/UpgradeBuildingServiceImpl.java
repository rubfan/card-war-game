package game.service.impl;

import game.dto.UpgradeBuildingDto;
import game.model.UpgradeBuildingEntity;
import game.repository.dao.UpgradeBuildingDao;
import game.service.UpgradeBuildingService;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


public class UpgradeBuildingServiceImpl implements UpgradeBuildingService {

    @Inject
    UpgradeBuildingDao upgradeBuildingDao;


    @Override
    public List<UpgradeBuildingDto> getUpgradesBuildings(String[] fieldName, Object[] fieldValues) {
        List<UpgradeBuildingEntity> upgradeBuildingEntityList= upgradeBuildingDao.getUpgradesBuildings(fieldName, fieldValues);
        List<UpgradeBuildingDto> res = new ArrayList<>();
        for (UpgradeBuildingEntity upgradeBuildingEntity : upgradeBuildingEntityList){
            UpgradeBuildingDto upgradeBuildingDto = new UpgradeBuildingDto();
            upgradeBuildingDto.setId(upgradeBuildingEntity.getId());
            upgradeBuildingDto.setUpgradeId(upgradeBuildingEntity.getUpgrageId());
            upgradeBuildingDto.setBuildingId(upgradeBuildingEntity.getBuildingId());
            upgradeBuildingDto.setPercent(upgradeBuildingEntity.getPercent());
            res.add(upgradeBuildingDto);
        }
        return  res;
    }
}

