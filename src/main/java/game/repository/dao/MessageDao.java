package game.repository.dao;

import game.dto.MessageDto;
import game.model.MessageEntity;

import javax.servlet.http.Cookie;
import javax.ws.rs.core.Response;
import java.util.List;

public interface MessageDao {
    String sendMessage(MessageEntity message, String accountId);
    List<MessageEntity> getRoomMessageList(String accountId1, String accountId2);
}
