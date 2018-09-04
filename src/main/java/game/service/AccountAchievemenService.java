package game.service;

import game.dto.AccountAchievementDto;

import java.util.List;

public interface AccountAchievemenService {
    List<AccountAchievementDto> getAccountAchievementList(Integer accountId);
    void deleteAccountAchievementList(Integer accountId);
    void updateAccountAchievementList(Integer accountId);
}
