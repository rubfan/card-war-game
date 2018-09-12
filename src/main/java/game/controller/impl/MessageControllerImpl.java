package game.controller.impl;

import game.controller.MessageController;
import game.dto.MessageDto;
import game.service.MessageService;
import org.junit.runners.Parameterized;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.annotation.Target;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Path("/message")
public class MessageControllerImpl implements MessageController {

    @Inject
    MessageService messageService;


    @POST
    @Path("send/{accountId}/{enemyAccountId}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response sendMessage( @BeanParam MessageDto message, @PathParam("accountId") String accountId, @PathParam("enemyAccountId") String enemyAccountId) {
        messageService.sendMessage(message, accountId, enemyAccountId);
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"MessageSend" );
        return Response.ok().build();

    }

    @GET
    @Path("list/{accountId1}/{accountId2}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<MessageDto> getRoomMessageList(@PathParam("accountId1") String accountId, @PathParam("accountId2") String enemyAccountId) {
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"MessageList" );

        return  messageService.getRoomMessageList(accountId, enemyAccountId);
    }
}
