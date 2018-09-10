package game.controller.impl;
/**
 * @author Evgen.Kaliba
 */
import game.controller.AccountResourceController;
import game.dto.AccountResourceDto;
import game.service.AccountResourceService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/accountresource/")
public class AccountResourceControllerImpl implements AccountResourceController {

        @Inject
        public AccountResourceService accountResourceService;

        @GET
        @Path("/list")
        @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
        public List<AccountResourceDto> getAccountResourceList(Integer accountId){
            List<AccountResourceDto> accountResourceList = accountResourceService.getAccountResourceList(accountId);
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, accountResourceList.toString());
            return accountResourceList;

        }


}
