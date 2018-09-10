package game.repository.dao.impl;

import game.dto.AccountDto;
import game.model.AccountEntity;
import game.model.AccountRoomEntity;
import game.model.RoomEntity;
import game.repository.dao.AccountDao;
import game.repository.dao.RoomDao;
import game.repository.helper.QueryHelper;
import game.service.AccountService;
import game.service.impl.AccountServiceImpl;

import javax.inject.Inject;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by ruslan.gramatic
 */

public class RoomDaoImpl implements RoomDao {

    public List<RoomEntity> getRoomList() {
        return new QueryHelper<List<RoomEntity>>() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<RoomEntity> rooms = new LinkedList<>();

                ResultSet rs = statement.executeQuery(
                        "select r.id, r.name, r.description, a1.id as a1_id, a2.id as a2_id,  u1.name as user_name, u2.name as user_name  from Room r\n" +
                                "left join Account a1 on a1.room_id=r.id \n" +
                                "left join Account a2 on a2.room_id=r.id AND a1.id<>a2.id \n" +
                                "left join User u1 on u1.id=a1.user_id\n" +
                                "left join User u2 on u2.id=a2.user_id\n" +
                                "group by r.id;"
                );
                while(rs.next()) {
                    RoomEntity room = new RoomEntity();
                    room.setId(rs.getInt("id"));
                    room.setName(rs.getString("name"));
                    room.setDescription(rs.getString("description"));
                    rooms.add(room);
                }
                returnResult(rooms);
            }
        }.run();
    }

    public List<AccountRoomEntity> getAccountRoomList(){
        return new QueryHelper<List<AccountRoomEntity>>() {
            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<AccountRoomEntity> roomAccounts = new LinkedList<>();
                ResultSet rs= statement.executeQuery("SELECT r.id, a1.id as account1, a2.id as account2 from Room r" +
                        "join Account a1 on a1.room_id=r.id" +
                        "join Account a2 on a2.room_id=r.id AND a1.id<>a2.id" +
                        "group by r.id;");
                while (rs.next()) {

                    AccountRoomEntity accountRoomEntity = new AccountRoomEntity();
                    AccountService accountService = new AccountServiceImpl();
                    accountRoomEntity.setRoomId(rs.getInt("id"));
                    accountRoomEntity.setAccount1(accountService.getAccount(rs.getInt("account1")));
                    accountRoomEntity.setAccount2(accountService.getAccount(rs.getInt("account2")));
                    roomAccounts.add(accountRoomEntity);
                }
                returnResult(roomAccounts);
            }
        }.run();
    }

    public void joinRoom(Integer roomId, Integer accountId) {
        new QueryHelper(){

            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement psmt = connection.prepareStatement("UPDATE Account SET room_id = ? WHERE id = ? ;");
                psmt.setInt(1, roomId);
                psmt.setInt(2,accountId);
                psmt.executeUpdate();
            }
        }.run();

    }

    public void leaveRoom(Integer roomId, Integer accountId) {
        new QueryHelper(){

            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement psmt = connection.prepareStatement("UPDATE  Account  SET " +
                        "room_id = NULL WHERE id = ? AND room_id = ?; ");
                psmt.setInt(1, accountId);
                psmt.setInt(2, roomId);
                psmt.executeUpdate();
            }
        }.run();

    }


}