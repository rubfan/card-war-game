package game.controller.impl;

import game.controller.AccountAchievementController;
import game.dto.AccountAchievementDto;
import game.service.AccountAchievemenService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/account_achieveent")
public class AccountAchievementControllerImpl implements AccountAchievementController {

    @Inject
    private AccountAchievemenService accountAchievemenService;

    @Override
    @GET
    @Path("/list/{accountId}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<AccountAchievementDto> getAccountAchievementList(@PathParam("accountId") Integer accountId) {
        return accountAchievemenService.getAccountAchievementList(accountId);
    }

    @Override
    @GET
    @Path("/delete/{accountId}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteAccountAchievementList(@PathParam("accountId") Integer accountId) {
        accountAchievemenService.deleteAccountAchievementList(accountId);
    }

    @Override
    @GET
    @Path("/update/{accountId}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void updateAccountAchievementList(@PathParam("accountId") Integer accountId) {
        accountAchievemenService.updateAccountAchievementList(accountId);
    }
}
