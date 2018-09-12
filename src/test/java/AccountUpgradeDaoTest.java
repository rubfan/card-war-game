import game.model.AccountUpgradeEntity;
import game.repository.dao.impl.AccountUpgradeDaoImpl;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountUpgradeDaoTest{

     AccountUpgradeDaoImpl accountUpgradeDao;

    @Before
    public void init(){
        accountUpgradeDao = new AccountUpgradeDaoImpl();
    }

    @Test
    public void test0clearAccountUpgrades(){
        accountUpgradeDao.eraseAccountUpgrade(1);
        assertTrue(accountUpgradeDao.getAccountUpgrades(null,null).size() == 0);

    }

    @Test
    public void test1AddSetAccountUpgrades(){
        List<AccountUpgradeEntity> accountUpgradeEntityList =
            new ArrayList<>();
        for (int i = 1; i< 5; i++){
            AccountUpgradeEntity accountUpgradeEntity = new AccountUpgradeEntity();
            accountUpgradeEntity.setAccountId(1);
            accountUpgradeEntity.setUpgradeId(i);
            accountUpgradeEntity.setNumber(2*i);
            accountUpgradeEntityList.add(accountUpgradeEntity);
        }
        accountUpgradeDao.setAccountUpgrade(accountUpgradeEntityList);

        assertTrue(accountUpgradeDao.getAccountUpgrades(null,null).size() == 4);
    }

    @Test
    public void test2GetAccountUpgradesByAccount(){
        System.out.println(accountUpgradeDao.getAccountUpgrades(new String[]{"account_id"},new Object[]{1}));
    }

    @Test
    public void test3GetUpgradesByAccount(){
        assertTrue(accountUpgradeDao.getAccountUpgrades(
                   new String[]{"account_upgrade.account_id"}, new Object[]{1}).size() == 4);
    }

    @Test
    public void test4GetUpgradeBuildingsByAccount(){
        assertTrue(accountUpgradeDao.getUpgradesBuildings(
                   new String[]{"account_upgrade.account_id"}, new Object[]{1}).size() == 9);
    }


}