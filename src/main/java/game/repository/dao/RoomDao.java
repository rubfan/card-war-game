package game.repository.dao;

import game.model.RoomEntity;

import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface RoomDao {
    List<RoomEntity> getRoomList();
    void joinRoom(Integer roomId, Integer accountId);
    void leaveRoom(Integer roomId, Integer accountId);
}
