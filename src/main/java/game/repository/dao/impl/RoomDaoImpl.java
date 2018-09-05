package game.repository.dao.impl;

import game.model.AccountRoomEntity;
import game.model.RoomEntity;
import game.repository.dao.RoomDao;
import game.repository.helper.QueryHelper;

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
                        "select r.id, r.name, r.description from Room r"
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
                ResultSet rs= statement.executeQuery("SELECT account_id FROM Account WHERE room_id IS NOT NULL GROUP BY room_id;");
                while (rs.next()) {
                    AccountRoomEntity roomAccount = new AccountRoomEntity();
                    roomAccount.setRoomId(roomAccount.getRoomId());
                    roomAccount.setAccount1(roomAccount.getAccount1());
                    roomAccount.setAccount2(roomAccount.getAccount2());
                    roomAccounts.add(roomAccount);
                }
                returnResult(roomAccounts);
            }
        }.run();
    }

    public void joinRoom(Integer roomId, Integer accountId) {
        new QueryHelper(){

            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement psmt = connection.prepareStatement("INSERT INTO Account(room_id) VALUES (?) WHERE account_id = ? ;");
                psmt.setInt(1, roomId);
                psmt.setInt(2,accountId);
            }
        }.run();

    }

    public void leaveRoom(Integer roomId, Integer accountId) {
        new QueryHelper(){

            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                PreparedStatement psmt = connection.prepareStatement("UPDATE TABLE Account SET room_id = NULL WHERE account_id = ? AND room_id = ?; ");
                psmt.setInt(1, accountId);
                psmt.setInt(2, roomId);
            }
        }.run();

    }
}