package game.service;

import game.dto.MessageDto;

import javax.servlet.http.Cookie;
import java.util.List;

public interface MessageService {
    String sendMessage(MessageDto message, String accountId);
    List<MessageDto> getRoomMessageList(String accountId1, String accountId2);
}
