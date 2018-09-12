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
    public String sendMessage(MessageDto message, String accountId, String enemyAccountId) {

        MessageEntity messageE = new MessageEntity();
        messageDao.sendMessage(messageE, accountId, enemyAccountId);
        MessageDto messageDto = new MessageDto(messageE);

        return messageDto.getText();
    }

    @Override
    public List<MessageDto> getRoomMessageList(String accountId, String enemyAccountId) {
        List<MessageDto> messages = new LinkedList<>();
        messageDao.getRoomMessageList(accountId, enemyAccountId).forEach(message ->
        messages.add(new MessageDto(message)));
        return messages;
    }
}
