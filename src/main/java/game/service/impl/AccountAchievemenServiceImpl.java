package game.service.impl;

import game.dto.AccountAchievementDto;
import game.repository.dao.*;
import game.service.AccountAchievemenService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class AccountAchievemenServiceImpl implements AccountAchievemenService {

    @Inject
    private AccountAchievementDao accountAchievementDao;

    @Override
    public List<AccountAchievementDto> getAccountAchievementList(Integer accountId) {
        final List<AccountAchievementDto> accountAchievementDtoList = new ArrayList<>();
        accountAchievementDao.getAccountAchievementList(accountId).forEach(accountAchievementEntity -> {
            accountAchievementDtoList.add(new AccountAchievementDto() {
                {
                    setAchievementId(accountAchievementEntity.getAchievement_id());
                    setNumber(accountAchievementEntity.getNumber());
                }
            });
        });
        return accountAchievementDtoList;
    }

    @Override
    public void deleteAccountAchievementList(Integer accountId) {
        accountAchievementDao.deleteAccountAchievementList(accountId);
    }

    @Override
    public void updateAccountAchievementList(Integer accountId) {
        accountAchievementDao.addAchievementToAccountAchievementList(accountId);
    }
}
