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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Path("/message")
public class MessageControllerImpl implements MessageController {

    @Inject
    MessageService messageService;


    @POST
    @Path("send/{accountId}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response sendMessage(@Context MessageDto message,@PathParam("accountId") String accountId) {
        messageService.sendMessage(message, accountId);
        return Response.ok().build();

    }

    @POST
    @Path("list/{accountId1}/{accountId2}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<MessageDto> getRoomMessageList(@PathParam("accountId1") String accountId1, @PathParam("accountId2") String accountId2) {
        List<MessageDto> roomMessageList = messageService.getRoomMessageList(accountId1, accountId2);
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, roomMessageList.toString());
        return roomMessageList;
//        return null;
    }
}
