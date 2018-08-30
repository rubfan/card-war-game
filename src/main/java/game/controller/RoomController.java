package game.controller;

import game.dto.AccountRoomDto;
import game.dto.RoomDto;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface RoomController {
    List<RoomDto> getAllRoomList();
    List<AccountRoomDto> getAccountRoomList();
    Response joinRoom(Integer roomId, Integer accountId);
    Response leaveRoom(Integer roomId, Integer accountId);
}
