package game.service.impl;

import game.dto.*;
import game.model.AccountUpgradeEntity;
import game.model.UpgradeBuildingEntity;
import game.model.UpgradeEntity;
import game.repository.dao.AccountUpgradeDao;
import game.service.AccountUpgradeService;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class AccountUpgradeServiceImpl implements AccountUpgradeService {

    @Inject
    AccountUpgradeDao accountUpgradeDao;

    @Override
    public List<AccountUpgradeDto> getAccountUpgrades(String[] fieldName, Object[] fieldValues){
        List<AccountUpgradeEntity> accountUpgradeEntityList = accountUpgradeDao.getAccountUpgrades(fieldName, fieldValues);
        List<AccountUpgradeDto> res = new ArrayList<>();
        for (AccountUpgradeEntity accountUpgradeEntity : accountUpgradeEntityList){
            AccountUpgradeDto accountUpgradeDto = new AccountUpgradeDto();
            accountUpgradeDto.setId(accountUpgradeEntity.getId());
            accountUpgradeDto.setAccountId(accountUpgradeEntity.getAccountId());
            accountUpgradeDto.setUpgradeId(accountUpgradeEntity.getUpgradeId());
            res.add(accountUpgradeDto);
        }
        return res;
    }

    @Override
    public List<AccountUpgradeDto> getAccountUpgrades(AccountDto accountDto){
        return getAccountUpgrades(new String[]{"id"}, new Object[]{accountDto.getId()});
    }

    @Override
    public List<UpgradeDto> getUpgrades(AccountDto accountDto){
        List<UpgradeEntity> upgradeEntityList = accountUpgradeDao.getUpgrades(new String[]{"account_upgrade.account_id"}, new Object[]{accountDto.getId()});
        List<UpgradeDto> res = new ArrayList<>();
        for (UpgradeEntity upgradeEntity : upgradeEntityList){
            UpgradeDto upgradeDto = new UpgradeDto();
            upgradeDto.setId(upgradeEntity.getId());
            upgradeDto.setName(upgradeEntity.getName());
            upgradeDto.setDescription(upgradeEntity.getDescription());
            res.add(upgradeDto);
        }
        return res;
    }

    @Override
    public List<UpgradeBuildingDto> getUpgradesBuildings(String[] fieldName, Object[] fieldValues) {
        List<UpgradeBuildingEntity> upgradeBuildingEntityList= accountUpgradeDao.getUpgradesBuildings(fieldName, fieldValues);
        List<UpgradeBuildingDto> res = new ArrayList<>();
        for (UpgradeBuildingEntity upgradeBuildingEntity : upgradeBuildingEntityList){
            UpgradeBuildingDto upgradeBuildingDto= new UpgradeBuildingDto();
            upgradeBuildingDto.setId(upgradeBuildingEntity.getId());
            upgradeBuildingDto.setBuildingId(upgradeBuildingEntity.getBuildingId());
            upgradeBuildingDto.setUpgradeId(upgradeBuildingEntity.getUpgrageId());
            upgradeBuildingDto.setPercent(upgradeBuildingEntity.getPercent());
            res.add(upgradeBuildingDto);
        }
        return res;
    }

    @Override
    public List<UpgradeBuildingDto> getUpgradesBuildings(BuildingDto buildingDto, AccountDto accountDto){
        return getUpgradesBuildings(new String[]{"account_upgrade.id", "upgrade_building.building_id"},
                                    new Object[]{accountDto.getId(), buildingDto.getId()});
    }

    @Override
    public float getTotalPercent(BuildingDto buildingDto, AccountDto accountDto){
        List<UpgradeBuildingDto> upgradeBuildingDtoList = getUpgradesBuildings(buildingDto, accountDto);
        float percent = 100;
        for (UpgradeBuildingDto upgradeBuildingDto : upgradeBuildingDtoList){
            percent  += upgradeBuildingDto.getPercent();
        }
        return  percent;
    }

    @Override
    public void eraseAccountUpgrade(AccountRoomDto accountRoomDto){
        accountUpgradeDao.eraseAccountUpgrade(accountRoomDto.getAccount1().getId());
        accountUpgradeDao.eraseAccountUpgrade(accountRoomDto.getAccount2().getId());
    }

    @Override
    public void onApplyCard(CardImpactDto cardImpactDto, AccountDto currentPlayer, AccountDto enemyPlayer) {
        setAccountUpgrades(cardImpactDto.getP1UpgradeAmountMap(), currentPlayer);
        setAccountUpgrades(cardImpactDto.getP2UpgradeAmountMap(), enemyPlayer);
    }

    @Override
    public void onGameOver(AccountRoomDto accountRoomDto) {
          eraseAccountUpgrade(accountRoomDto);
    }

    private void setAccountUpgrades(Map<Integer, Float> upgradeData , AccountDto player){
        for (Map.Entry<Integer, Float> entry : upgradeData.entrySet()){
            int upgradeId = entry.getKey();
            int upgradeAmount = Math.round(entry.getValue());
            AccountUpgradeEntity accountUpgradeEntity = new AccountUpgradeEntity();
            accountUpgradeEntity.setAccountId(player.getId());
            accountUpgradeEntity.setUpgradeId(upgradeId);
            List<AccountUpgradeEntity> accountUpgradeEntityList = new ArrayList<>();
            for(int i = 0; i < upgradeAmount; i++)
                accountUpgradeEntityList.add(accountUpgradeEntity);
            accountUpgradeDao.setAccountUpgrade(accountUpgradeEntityList);
        }
    }


}
