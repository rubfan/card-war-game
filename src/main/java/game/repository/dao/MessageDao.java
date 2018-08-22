package game.repository.dao;

import game.dto.MessageDto;
import game.model.MessageEntity;

import javax.servlet.http.Cookie;
import javax.ws.rs.core.Response;
import java.util.List;

public interface MessageDao {
    List<MessageEntity> getMessageList();
    String sendMessage(MessageEntity message, Cookie cookie);
    List<MessageEntity> getRoomMessageList(Cookie cookie);
}
