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

    @Override
    public List<MessageEntity> getMessageList() {
        return new QueryHelper<List<MessageEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<MessageEntity> messages = new LinkedList<>();
                ResultSet rs = statement.executeQuery(
                        "select id, text, from_account_id, to_account_id, time from Message"
                );
                while(rs.next()) {
                    MessageEntity message = new MessageEntity();
                    message.setId(rs.getInt("id"));
                    message.setText(rs.getString("text"));
                    message.setFromAccountId(rs.getInt("from_account_id"));
                    message.setFromAccountId(rs.getInt("to_account_id"));
                    message.setTime(rs.getDate("time"));
                    messages.add(message);
                }
                returnResult(messages);
            }
        }.run();
    }

    @Override
    public String sendMessage(MessageEntity message, Cookie cookie) {
         return  new QueryHelper<String>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement psmt = connection.prepareStatement(
                        "INSERT INTO Message(text, from_account_id, to_account_id, time) VALUES (?, ?, ? ,?)"
                );
                psmt.setString(1, message.getText());
                psmt.setInt(2, message.getFromAccountId());
                psmt.setInt(3, message.getToAccountId());
                psmt.setDate(4, (Date) message.getTime());
            }
        }.run();
    }

    @Override
    public List<MessageEntity> getRoomMessageList(Cookie cookie) {
        return new QueryHelper<List<MessageEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<MessageEntity> messages = new LinkedList<>();
                ResultSet rs = statement.executeQuery(
                        "select id, text, from_account_id, to_account_id, time from Message" +
                                "JOIN Account ON Account.id=Message.from_account_id OR Account.id=Message.to_account_id"
                );
                while(rs.next()) {
                    MessageEntity message = new MessageEntity();
                    message.setId(rs.getInt("id"));
                    message.setText(rs.getString("text"));
                    message.setFromAccountId(rs.getInt("from_account_id"));
                    message.setFromAccountId(rs.getInt("to_account_id"));
                    message.setTime(rs.getDate("time"));
                    messages.add(message);
                }
                returnResult(messages);
            }
        }.run();
    }
}
