package game.service.impl;

import game.dto.MessageDto;
import game.model.MessageEntity;
import game.repository.dao.MessageDao;
import game.service.MessageService;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import java.util.LinkedList;
import java.util.List;

public class MessageServiceImpl implements MessageService {

    @Inject
    MessageDao messageDao;

    @Override
    public String sendMessage(String message, String accountId, String enemyAccountId) {



        return messageDao.sendMessage(message, accountId, enemyAccountId);
    }

    @Override
    public List<MessageDto> getRoomMessageList(String accountId, String enemyAccountId) {
        List<MessageDto> messages = new LinkedList<>();
        messageDao.getRoomMessageList(accountId, enemyAccountId).forEach(messageEntity ->
        messages.add(new MessageDto(messageEntity.getId(), messageEntity.getText(), messageEntity.getFromAccountId(), messageEntity.getToAccountId(), messageEntity.getTime())));
        return messages;
    }
}
