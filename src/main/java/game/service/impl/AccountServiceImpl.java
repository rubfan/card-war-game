package game.service.impl;

import game.dto.AccountDto;
import game.model.AccountEntity;
import game.repository.dao.AccountDao;
import game.service.AccountService;

import javax.inject.Inject;

public class AccountServiceImpl implements AccountService {
    @Inject
    AccountDao accountDao;

    @Override
    public AccountDto getAccount(Integer accountId) {
            AccountEntity accountEntity = accountDao.getAccount(accountId);

            return new AccountDto(){{
                    accountEntity.getId();
                    accountEntity.getUser();
                    accountEntity.getRoom();
            }};
           }
}
