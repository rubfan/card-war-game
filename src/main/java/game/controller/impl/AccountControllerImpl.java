package game.controller.impl;

import game.controller.AccountController;
import game.dto.AccountDto;
import game.repository.helper.QueryHelper;
import game.service.AccountService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/account")
public class AccountControllerImpl implements AccountController {

    @Inject
    public AccountService accountService;

    @Override
    public AccountDto getAccount(Integer accountId) {
        return accountService.getAccount(accountId);
    }
}
