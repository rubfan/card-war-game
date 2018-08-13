package game.controller;

import game.dto.AccountDto;

/**
 * @author ruslan.gramatic
 */
public interface AccountController {
    AccountDto getAccount(Integer accountId);
}
