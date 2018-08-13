package game.controller;

import game.dto.AccountAchievementDto;

import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface AccountAchievementController {
    List<AccountAchievementDto> getAccountAchievementsList(Integer accountId);
}
