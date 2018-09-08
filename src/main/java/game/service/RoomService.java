package game.service;

import game.dto.AccountRoomDto;
import game.dto.RoomDto;

import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface RoomService {
    List<RoomDto> getRoomList();
    List<AccountRoomDto> getAccountRoomList();
    void joinRoom(Integer roomId, Integer accountId);
    void leaveRoom(Integer roomId, Integer accountId);
}
