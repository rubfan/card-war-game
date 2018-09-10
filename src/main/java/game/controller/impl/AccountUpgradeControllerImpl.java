package game.controller.impl;

import game.controller.AccountUpgradeController;
import game.dto.AccountDto;
import game.dto.AccountUpgradeDto;
import game.service.AccountUpgradeService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/account_upgrade")
public class AccountUpgradeControllerImpl implements AccountUpgradeController {

    @Inject
    AccountUpgradeService accountUpgradeService;

    @Override
    @GET
    @Path("/list/{accountId}")
    public List<AccountUpgradeDto> getAccountUpgradeList(@PathParam("accountId")Integer accountId) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(accountId);
        return accountUpgradeService.getAccountUpgrades(accountDto);
    }
}
