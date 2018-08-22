package game.service;

import game.dto.MessageDto;

import javax.servlet.http.Cookie;
import java.util.List;

public interface MessageService {
    List<MessageDto> getMessageList();
    String sendMessage(MessageDto message, Cookie cookie);
    List<MessageDto> getRoomMessageList(Cookie cookie);
}
