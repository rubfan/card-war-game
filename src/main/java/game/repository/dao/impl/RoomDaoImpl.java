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

    public List<AccountRoomEntity> getAccountRoomList(){ return  null;
//        return new QueryHelper<List<AccountRoomEntity>>() {
//            @Override
//            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
//                List<AccountRoomEntity> rooms = new LinkedList<>();
//
//            }
//        }
    }

    public void joinRoom(Integer roomId, Integer accountId) {
//        new QueryHelper(){
//
//            @Override
//            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
//                PreparedStatement psmt = statement.executeQuery("INSERT INTO ()")
//            }
//        }

    }

    public void leaveRoom(Integer roomId, Integer accountId) {

    }
}
