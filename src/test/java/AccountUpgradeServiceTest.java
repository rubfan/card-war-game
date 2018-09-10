import game.dto.AccountDto;
import game.dto.AccountRoomDto;
import game.dto.BuildingDto;
import game.dto.RoomDto;
import game.repository.dao.impl.AccountUpgradeDaoImpl;
import game.service.AccountUpgradeService;
import game.service.impl.AccountUpgradeServiceImpl;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.lang.reflect.Field;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountUpgradeServiceTest {

    AccountUpgradeDaoImpl accountUpgradeDao;
    AccountUpgradeServiceImpl accountUpgradeService;
    BuildingDto buildingDto =  new BuildingDto();
    AccountDto accountDto = new AccountDto();
    AccountDto accountDto2 = new AccountDto();
    AccountRoomDto  accountRoomDto = new AccountRoomDto();

    @Before
    public void init() throws NoSuchFieldException, IllegalAccessException {
        accountUpgradeDao = new AccountUpgradeDaoImpl();
        accountUpgradeService = new AccountUpgradeServiceImpl();
        Field declaredField = AccountUpgradeServiceImpl.class.getDeclaredField("accountUpgradeDao");
        declaredField.setAccessible(true);
        declaredField.set(accountUpgradeService, accountUpgradeDao);

        buildingDto.setId(1);
        accountDto.setId(1);
        accountDto2.setId(2);
        accountRoomDto.setAccount1(accountDto);
        accountRoomDto.setAccount2(accountDto2);
    }

    @Test
    public void test0(){
        assertTrue(accountUpgradeService.getAccountUpgrades(1).size() == 4);
    }

    @Test
    public void test1GetTotalPercentByAccountAndBuilding(){
        assertTrue(accountUpgradeService.getTotalPercent(buildingDto, accountDto) == 200);
    }

    @Test
    public void test2GetUpgradeBuildingsByAccountAndBuilding(){
        assertTrue(accountUpgradeService.getUpgradesBuildings(buildingDto, accountDto).size() == 4);
    }

    @Test
    public void test3setAccountUpgrades(){
        HashMap<Integer, Float> upgr = new HashMap<>();
        upgr.put(1,1f);
        upgr.put(2,111f);
        accountUpgradeService.setAccountUpgrades(upgr, accountDto2);
        assertTrue(accountUpgradeService.getUpgrades(accountDto2).size() == 2);
        accountUpgradeService.eraseAccountUpgrade(accountRoomDto);
    }





}
