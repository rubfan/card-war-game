package game.repository.dao.impl;

import game.dto.UserDto;
import game.model.AccountEntity;
import game.repository.dao.AccountDao;
import game.repository.helper.QueryHelper;

import java.sql.*;


public class AccountDaoImpl implements AccountDao {


    @Override
    public AccountEntity getAccount(Integer accountId) { return null;

//        return new QueryHelper<AccountEntity>() {
//            protected void executeQuery (Statement statement, Connection connection) throws SQLException {
//                PreparedStatement pstmt = connection.prepareStatement(
//                        "SELECT * from Account" +
//                                "WHERE id = ?;");
//                        pstmt.setInt(1, Integer.valueOf(accountId));
//                ResultSet rs = pstmt.executeQuery();
//                if (rs.next()) returnResult(new AccountEntity(
//                        rs.getInt("id"),
//                        rs.getInt("user_id"),
//                        rs.getInt("room_id"),
//                        rs.getTimestamp("start_game_time")));
//            }
//        }.run();
    }
}