package game.repository.dao;

import game.dto.AccountAchievementDto;
import game.model.AccountAchievementEntity;

import java.util.List;

public interface AccountAchievement {
    List<AccountAchievementEntity> getAccountAchievementList();
    void addAccountAchievemen(AccountAchievementDto accountAchievementDto);
    void clearAccountAchievementList(int accountId);
    void addAchievementToAccount(int accountId, int achievementId);
}
