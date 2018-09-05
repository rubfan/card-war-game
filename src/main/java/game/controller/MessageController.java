package game.controller;

import game.dto.MessageDto;

import javax.servlet.http.Cookie;
import javax.ws.rs.core.Response;

import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface MessageController {
    Response sendMessage(MessageDto message, String accountId);
    List<MessageDto> getRoomMessageList(String accountId1, String accountId2);
}