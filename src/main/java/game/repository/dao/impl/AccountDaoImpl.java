package game.repository.dao.impl;

import game.dto.RoomDto;
import game.dto.UserDto;
import game.model.AccountEntity;
import game.model.RoomEntity;
import game.repository.dao.AccountDao;
import game.repository.dao.UserDao;
import game.repository.helper.QueryHelper;
import game.service.RoomService;
import game.service.UserService;

import javax.inject.Inject;
import java.sql.*;




public class AccountDaoImpl implements AccountDao{

    public RoomService room;
    public UserService user;

    public AccountEntity getAccount(Integer accountId) {

        return new QueryHelper<AccountEntity>() {
            protected void executeQuery (Statement statement, Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "SELECT id, user_id, room_id FROM Account WHERE id = ?");
                pstmt.setInt(1, accountId);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    returnResult(new AccountEntity (
                            rs.getInt("id"),
                            user.getUserById(accountId),
                            room.getRoomDto(rs.getInt("room_id"))
                    ));
                }

            }
        }.run();
    }

}