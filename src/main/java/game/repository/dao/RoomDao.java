package game.repository.dao;

import game.model.AccountRoomEntity;
import game.model.RoomEntity;

import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface RoomDao {
    List<RoomEntity> getRoomList();
    List<AccountRoomEntity> getAccountRoomList();
    void joinRoom(Integer roomId, Integer accountId);
    RoomEntity getRoomDto (Integer roomId);
}
