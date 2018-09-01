package game.repository.dao;


import game.model.AccountEntity;

public interface AccountDao {
    AccountEntity getAccount(Integer accountId);
}
