package game.controller.impl;

import game.controller.MessageController;
import game.dto.MessageDto;
import game.model.RoomEntity;
import game.repository.helper.QueryHelper;
import game.service.MessageService;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Path("/message")
public class MessageControllerImpl implements MessageController {

    @Inject
    MessageService messageService;

    @GET
    @Path("list")
    @Override
    public List<MessageDto> getMessageList() {
        List<MessageDto> messageList = messageService.getMessageList();
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, messageList.toString());
        return messageList;

    }

    @PUT
    @Path("send")
    @Override
    public Response sendMessage(MessageDto message, Cookie cookie) {
        messageService.sendMessage(message, cookie);
        return Response.ok().build();
    }

    @GET
    @Path("roommessagelist")
    @Override
    public List<MessageDto> getRoomMessageList(Cookie cookie) {
        List<MessageDto> roomMessageList = messageService.getRoomMessageList(cookie);
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, roomMessageList.toString());
        return roomMessageList;
    }
}
