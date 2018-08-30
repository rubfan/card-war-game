package game.service;

import game.dto.RoomDto;

import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface RoomService {
    List<RoomDto> getRoomList();
    void joinRoom(Integer roomId, Integer accountId);
    void leaveRoom(Integer roomId, Integer accountId);
}
