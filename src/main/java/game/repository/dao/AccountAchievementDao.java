package game.repository.dao;

import game.model.AccountAchievementEntity;

import java.util.List;

public interface AccountAchievementDao {
    List<AccountAchievementEntity> getAccountAchievementList(Integer accountId);
    void deleteAccountAchievementList(Integer accountId);
    void addAchievementToAccountAchievementList(Integer accountId, Integer achievementId);
}
