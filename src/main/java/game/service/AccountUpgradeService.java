package game.service;

import game.dto.*;

import java.util.List;

public interface AccountUpgradeService {
    List<AccountUpgradeDto> getAccountUpgrades(String[] fieldName, Object[] fieldValues);

    List<AccountUpgradeDto> getAccountUpgrades(AccountDto accountDto);

    List<AccountUpgradeDto> getAccountUpgrades(int accountId);

    List<UpgradeDto> getUpgrades(AccountDto accountDto);

    List<UpgradeBuildingDto> getUpgradesBuildings(String[] fieldName, Object[] fieldValues);

    List<UpgradeBuildingDto> getUpgradesBuildings(BuildingDto buildingDto, AccountDto accountDto);

    float getTotalPercent(BuildingDto buildingDto, AccountDto accountDto);

    void eraseAccountUpgrade(AccountRoomDto accountRoomDto);

    void onApplyCard(List<CardImpactDto> cardImpactDtoList, AccountDto currentPlayer, AccountDto enemyPlayer);

    void onGameOver(AccountRoomDto accountRoomDto);
}
