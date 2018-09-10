package game.controller.impl;

import game.controller.AccountController;
import game.dto.AccountDto;
import game.repository.helper.QueryHelper;
import game.service.AccountService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/account")
public class AccountControllerImpl implements AccountController {

    @Inject
    public AccountService accountService;

    @GET
    @Path("{accountId}")
    public AccountDto getAccount(@PathParam("accountId") Integer accountId) {
        return accountService.getAccount(accountId);
    }
}
