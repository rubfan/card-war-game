package game.repository.dao.impl;

import game.dto.MessageDto;
import game.model.MessageEntity;
import game.repository.dao.MessageDao;
import game.repository.helper.QueryHelper;

import javax.servlet.http.Cookie;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class MessageDaoImpl implements MessageDao {

    public List<MessageEntity> getMessageList() {
        return null;
//        return new QueryHelper<List<MessageEntity>>() {
//            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
//                List<MessageEntity> messages = new LinkedList<>();
//                ResultSet rs = statement.executeQuery(
//                        "select id, text, from_account_id, to_account_id, time from Message"
//                );
//                while(rs.next()) {
//                    MessageEntity message = new MessageEntity();
//                    message.setId(rs.getInt("id"));
//                    message.setText(rs.getString("text"));
//                    message.setFromAccountId(rs.getInt("from_account_id"));
//                    message.setFromAccountId(rs.getInt("to_account_id"));
//                    message.setTime(rs.getDate("time"));
//                    messages.add(message);
//                }
//                returnResult(messages);
//            }
//        }.run();
    }

    @Override
    public String sendMessage(MessageEntity message, String accountId) {
         return  new QueryHelper<String>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement psmt = connection.prepareStatement(
                        "INSERT INTO Message(text, from_account_id, to_account_id, time) VALUES (?, ?, ? ,?)"
                );
                psmt.setString(1, message.getText());
                psmt.setInt(2, message.getFromAccountId());
                psmt.setInt(3, message.getToAccountId());
                psmt.setDate(4, (Date) message.getTime());
                psmt.executeUpdate();
                returnResult(message.getText());
            }
        }.run();
    }

    @Override
    public List<MessageEntity> getRoomMessageList(String accountId1, String accountId2) {
        return new QueryHelper<List<MessageEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<MessageEntity> messages = new LinkedList<>();
                ResultSet rs = statement.executeQuery(
                        "select id, text, from_account_id, to_account_id, time from Message " +
                                "JOIN Account a1 ON a1.id=Message.from_account_id " +
                                "JOIN Account a2 ON a2.id=Message.to_account_id " +
                                "WHERE a1.room_id=a2.room_id ;"
                );
                while(rs.next()) {
                    MessageEntity message = new MessageEntity();
                    message.setId(rs.getInt("id"));
                    message.setText(rs.getString("text"));
                    message.setFromAccountId(rs.getInt("from_account_id"));
                    message.setToAccountId(rs.getInt("to_account_id"));
                    message.setTime(rs.getDate("time"));
                    messages.add(message);
                }
                returnResult(messages);
            }
        }.run();
    }
}
