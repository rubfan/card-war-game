package game.repository.dao;

import game.model.AccountResourceEntity;

import java.util.List;

public interface AccountResourceDao {
    List<AccountResourceEntity> getAccountResourceList(Integer accountId);
    void clearAccountResourceList(Integer accountId);
}
