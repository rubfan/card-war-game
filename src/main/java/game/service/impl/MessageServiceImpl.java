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

//    @Override
//    public List<MessageDto> getMessageList() {
//        final List<MessageDto> messages = new LinkedList<>();
////        messageDao.getMessageList().forEach(messageEntity ->
////        messages.add(new MessageDto(){{
////            setId(messageEntity.getId());
////            setText(messageEntity.getText());
////            setFromAccountId(messageEntity.getFromAccountId());
////            setToAccountId(messageEntity.getToAccountId());
////            setTime(messageEntity.getTime());
////        }}));
////
////        return messages;
//        return messages;
//    }

    @Override
    public String sendMessage(MessageDto message, String accountId) {

        MessageEntity messageE = new MessageEntity();
        messageDao.sendMessage(messageE, accountId);
        MessageDto messageDto = new MessageDto(){{
            setId(messageE.getId());
            setText(messageE.getText());
            setFromAccountId(messageE.getFromAccountId());
            setToAccountId(messageE.getToAccountId());
            setTime(messageE.getTime());}};

        return messageDto.getText();
    }

    @Override
    public List<MessageDto> getRoomMessageList(String accountId1, String accountId2) {
        List<MessageDto> messages = new LinkedList<>();
        messageDao.getRoomMessageList(accountId1, accountId2).forEach(messageEntity ->
        messages.add(new MessageDto(){{
            setId(messageEntity.getId());
            setText(messageEntity.getText());
            setFromAccountId(messageEntity.getFromAccountId());
            setToAccountId(messageEntity.getToAccountId());
            setTime(messageEntity.getTime());
        }}));
        return messages;
    }
}
