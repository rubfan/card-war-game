package game.service.impl;

import game.model.MessageEntity;
import game.repository.dao.MessageDao;
import game.repository.dao.impl.MessageDaoImpl;
import org.junit.Before;
import org.junit.Test;


import javax.inject.Inject;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;

public class MessageServiceImplTest extends MessageServiceImpl {

    @Inject
    MessageDao message;

//    @Before
//        public void initMessage() {
//            message = new MessageDaoImpl();
//
//            message.setText("aaa");
//            message.setFromAccountId(1);
//            message.setToAccountId(2);
//            message.setTime(new Date(System.currentTimeMillis()));
//        }




//    @Test
//    public void sendMessage() {
//        String mes = "aaa";
//        assertEquals("aaa", mes, message.getText());
//        assertNotNull(message.getText());
//    }


    @Test
    public void getRoomMessageList() {
        System.out.println(Arrays.toString(new String[]{"accountId"}));
        System.out.println(new Date());
    }
}