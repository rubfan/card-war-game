package game.controller;

import game.dto.AccountAchievementDto;

import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface AccountAchievementController {
    List<AccountAchievementDto> getAccountAchievementList(Integer accountId);
    void deleteAccountAchievementList(Integer accountId);
    void updateAccountAchievementList(Integer accountId);
}