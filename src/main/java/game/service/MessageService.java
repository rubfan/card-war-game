package game.service;

import game.dto.MessageDto;

import javax.servlet.http.Cookie;
import java.util.List;

public interface MessageService {
    String sendMessage(String message, String accountId, String enemyAccountId);
    List<MessageDto> getRoomMessageList(String accountId1, String enemyAccountId);
}
