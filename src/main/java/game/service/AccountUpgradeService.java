package game.service;

import game.dto.*;

import java.util.List;
import java.util.Map;

public interface AccountUpgradeService {
    List<AccountUpgradeDto> getAccountUpgrades(String[] fieldName, Object[] fieldValues);

    List<AccountUpgradeDto> getAccountUpgrades(AccountDto accountDto);

    List<AccountUpgradeDto> getAccountUpgrades(int accountId);

    Map<UpgradeDto, Integer> getUpgrades(AccountDto accountDto);

    Map<UpgradeBuildingDto, Integer> getUpgradesBuildings(String[] fieldName, Object[] fieldValues);

    Map<UpgradeBuildingDto, Integer> getUpgradesBuildings(BuildingDto buildingDto, AccountDto accountDto);

    float getTotalPercent(BuildingDto buildingDto, AccountDto accountDto);

    void eraseAccountUpgrade(AccountRoomDto accountRoomDto);

    void onApplyCard(List<CardImpactDto> cardImpactDtoList, AccountDto currentPlayer, AccountDto enemyPlayer);

    void onGameOver(AccountRoomDto accountRoomDto);
}
