package game.repository.dao.impl;

import game.model.MessageEntity;
import game.repository.dao.MessageDao;
import game.repository.helper.QueryHelper;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;


public class MessageDaoImpl implements MessageDao {



    @Override
    public String sendMessage(String message, String accountId, String enemyAccountId) {
         return  new QueryHelper<String>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement psmt = connection.prepareStatement(
                        "INSERT INTO Message(text, from_account_id, to_account_id, time) VALUES (?, ?, ? ,?)"
                );
                psmt.setString(1, message);
                psmt.setInt(2, Integer.parseInt(accountId));
                psmt.setInt(3, Integer.parseInt(enemyAccountId));
                psmt.setString(4, new Date().toString());
                psmt.executeUpdate();

                returnResult(message);
            }
        }.run();
    }

    @Override
    public List<MessageEntity> getRoomMessageList(String accountId, String enemyAccountId) {
        return new QueryHelper<List<MessageEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<MessageEntity> messages = new LinkedList<>();
                PreparedStatement psmt = connection.prepareStatement("select m.id, m.text, m.from_account_id, m.to_account_id/*, m.time */ from Message m \n" +
                        "JOIN Account a1 ON a1.id=m.from_account_id \n" +
                        "JOIN Account a2 ON a2.id=m.to_account_id \n" +
                        "WHERE a1.id=? AND a2.id = ? OR a1.id= ? AND a2.id = ? " +
                        "ORDER BY time;"
                );

                psmt.setInt(1, Integer.parseInt(accountId));
                psmt.setInt(2, Integer.parseInt(enemyAccountId));
                psmt.setInt(3, Integer.parseInt(enemyAccountId));
                psmt.setInt(4, Integer.parseInt(accountId));

                ResultSet rs = psmt.executeQuery();
                while(rs.next()) {
                    MessageEntity message = new MessageEntity();
                    message.setId(rs.getInt("id"));
                    message.setText(rs.getString("text"));
                    message.setFromAccountId(rs.getInt("from_account_id"));
                    message.setToAccountId(rs.getInt("to_account_id"));
                    messages.add(message);
                }
                returnResult(messages);
            }
        }.run();
    }
}
