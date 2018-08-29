package game.controller.impl;

import game.controller.MessageController;
import game.dto.MessageDto;
import game.service.MessageService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


//@Path("/message")
//public class MessageControllerImpl implements MessageController {
//
//    @Inject
//    MessageService messageService;
//
//
//    @POST
//    @Path("send{message}{accountId}")
//    @Override
//    public Response sendMessage(@PathParam("message") MessageDto message, String accountId) {
//        messageService.sendMessage(message, accountId);
//        return Response.ok().build();
//
//    }
//
//    @GET
////    @Path("list")
//    @Override
//    public List<MessageDto> getRoomMessageList(@Context String accountId1,@Context String accountId2) {
////        List<MessageDto> roomMessageList = messageService.getRoomMessageList(accountId1, accountId2);
////        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, roomMessageList.toString());
////        return roomMessageList;
//        return null;
//    }
//}
