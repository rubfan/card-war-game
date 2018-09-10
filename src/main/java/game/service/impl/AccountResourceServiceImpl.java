package game.service.impl;

import game.dto.AccountResourceDto;
import game.repository.dao.AccountResourceDao;
import game.service.AccountResourceService;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Evgen.Kaliba
 */

public class AccountResourceServiceImpl implements AccountResourceService {

    @Inject
    AccountResourceDao accountResourceDao;

    @Override
    public List<AccountResourceDto> getAccountResourceList(Integer accountId) {
         List<AccountResourceDto> accountResource = new LinkedList<>();
        accountResourceDao.getAccountResourceList(accountId).forEach(accountResourceEntity -> {
            accountResource.add(new AccountResourceDto() {
                {
                    setResourceId(accountResourceEntity.getResourceId());
                    setAmount(accountResourceEntity.getAmount());
                    setNumPerMin(accountResourceEntity.getNumPerMin());
                }
            });
        });
        return accountResource;
    }

    @Override
     public void clearAccountResourceList(Integer accountId) {
        accountResourceDao.clearAccountResourceList(accountId);
        }

}
