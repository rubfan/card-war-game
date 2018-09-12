package game.controller.impl;

import game.controller.AccountAchievementController;
import game.dto.AccountAchievementDto;
import game.service.AccountAchievemenService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

/**
 * @author alexey.kostash
 */

@Path("/account_achieveent")
public class AccountAchievementControllerImpl implements AccountAchievementController {

    @Inject
    private AccountAchievemenService accountAchievemenService;

    @Override
    @GET
    @Path("/list/{accountId}")
    public List<AccountAchievementDto> getAccountAchievementList(@PathParam("accountId") Integer accountId) {
        return accountAchievemenService.getAccountAchievementList(accountId);
    }

    @Override
    @GET
    @Path("/delete/{accountId}")
    public void deleteAccountAchievementList(@PathParam("accountId") Integer accountId) {
        accountAchievemenService.deleteAccountAchievementList(accountId);
    }

    @Override
    @GET
    @Path("/update/{accountId}")
    public void updateAccountAchievementList(@PathParam("accountId") Integer accountId) {
        accountAchievemenService.updateAccountAchievementList(accountId);
    }
}
