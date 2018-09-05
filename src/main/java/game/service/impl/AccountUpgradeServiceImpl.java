package game.service.impl;

import game.dto.*;
import game.model.AccountUpgradeEntity;
import game.model.UpgradeBuildingEntity;
import game.model.UpgradeEntity;
import game.repository.dao.AccountUpgradeDao;
import game.service.AccountUpgradeService;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
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
            accountUpgradeDto.setNumber(accountUpgradeEntity.getNumber());
            res.add(accountUpgradeDto);
        }
        return res;
    }

    @Override
    public List<AccountUpgradeDto> getAccountUpgrades(AccountDto accountDto){
        return getAccountUpgrades(new String[]{"account_id"}, new Object[]{accountDto.getId()});
    }

    @Override
    public List<AccountUpgradeDto> getAccountUpgrades(int accountId) {
        return getAccountUpgrades(new String[]{"account_id"}, new Object[]{accountId});
    }

    @Override
    public Map<UpgradeDto, Integer> getUpgrades(AccountDto accountDto){
        Map<UpgradeEntity, Integer> upgradeEntityList = accountUpgradeDao.getUpgrades(new String[]{"account_upgrade.account_id"}, new Object[]{accountDto.getId()});
        Map<UpgradeDto, Integer> res = new HashMap<>();
        for (Map.Entry<UpgradeEntity, Integer> upgradeEntity : upgradeEntityList.entrySet()){
            UpgradeDto upgradeDto = new UpgradeDto();
            upgradeDto.setId(upgradeEntity.getKey().getId());
            upgradeDto.setName(upgradeEntity.getKey().getName());
            upgradeDto.setDescription(upgradeEntity.getKey().getDescription());
            res.put(upgradeDto, upgradeEntity.getValue());
        }
        return res;
    }

    @Override
    public Map<UpgradeBuildingDto, Integer> getUpgradesBuildings(String[] fieldName, Object[] fieldValues) {
        Map<UpgradeBuildingEntity, Integer> upgradeBuildingEntityList= accountUpgradeDao.getUpgradesBuildings(fieldName, fieldValues);
        Map<UpgradeBuildingDto, Integer> res = new HashMap<>();
        for (Map.Entry<UpgradeBuildingEntity, Integer> upgradeBuildingEntity : upgradeBuildingEntityList.entrySet()){
            UpgradeBuildingDto upgradeBuildingDto= new UpgradeBuildingDto();
            upgradeBuildingDto.setId(upgradeBuildingEntity.getKey().getId());
            upgradeBuildingDto.setBuildingId(upgradeBuildingEntity.getKey().getBuildingId());
            upgradeBuildingDto.setUpgradeId(upgradeBuildingEntity.getKey().getUpgrageId());
            upgradeBuildingDto.setPercent(upgradeBuildingEntity.getKey().getPercent());
            res.put(upgradeBuildingDto, upgradeBuildingEntity.getValue());
        }
        return res;
    }

    @Override
    public Map<UpgradeBuildingDto, Integer> getUpgradesBuildings(BuildingDto buildingDto, AccountDto accountDto){
        return getUpgradesBuildings(new String[]{"account_upgrade.account_id", "upgrade_building.building_id"},
                                    new Object[]{accountDto.getId(), buildingDto.getId()});
    }

    @Override
    public float getTotalPercent(BuildingDto buildingDto, AccountDto accountDto){
        Map<UpgradeBuildingDto, Integer> upgradeBuildingDtoList = getUpgradesBuildings(buildingDto, accountDto);
        float percent = 100;
        for (Map.Entry<UpgradeBuildingDto, Integer> upgradeBuildingDto : upgradeBuildingDtoList.entrySet()){
            percent  += upgradeBuildingDto.getKey().getPercent() *
                        upgradeBuildingDto.getValue();
        }
        return  percent;
    }

    @Override
    public void eraseAccountUpgrade(AccountRoomDto accountRoomDto){
        accountUpgradeDao.eraseAccountUpgrade(accountRoomDto.getAccount1().getId());
        accountUpgradeDao.eraseAccountUpgrade(accountRoomDto.getAccount2().getId());
    }

    @Override
    public void onApplyCard(List<CardImpactDto> cardImpactDtoList, AccountDto currentPlayer, AccountDto enemyPlayer) {
        for (CardImpactDto cardImpactDto :cardImpactDtoList) {
            setAccountUpgrades(cardImpactDto.getP1UpgradeAmountMap(), currentPlayer);
            setAccountUpgrades(cardImpactDto.getP2UpgradeAmountMap(), enemyPlayer);
        }
    }

    @Override
    public void onGameOver(AccountRoomDto accountRoomDto) {
          eraseAccountUpgrade(accountRoomDto);
    }

    public void setAccountUpgrades(Map<Integer, Float> upgradeData , AccountDto player){
        List<AccountUpgradeEntity> accountUpgradeEntityList = new ArrayList<>();
        for (Map.Entry<Integer, Float> entry : upgradeData.entrySet()){
            int upgradeId = entry.getKey();
            int upgradeAmount = Math.round(entry.getValue());
            AccountUpgradeEntity accountUpgradeEntity = new AccountUpgradeEntity();
            accountUpgradeEntity.setAccountId(player.getId());
            accountUpgradeEntity.setUpgradeId(upgradeId);
            accountUpgradeEntity.setNumber(upgradeAmount);
            accountUpgradeEntityList.add(accountUpgradeEntity);
        }
            accountUpgradeDao.setAccountUpgrade(accountUpgradeEntityList);
    }


}
