package game.service.impl;

import game.dto.AccountRoomDto;
import game.dto.RoomDto;
import game.repository.dao.RoomDao;
import game.service.RoomService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ruslan.gramatic
 */
public class RoomServiceImpl implements RoomService {

    @Inject
    public RoomDao roomDao;

    public List<RoomDto> getRoomList() {
        final List<RoomDto> rooms = new LinkedList<>();
        roomDao.getRoomList().forEach(roomEntity -> rooms.add(new RoomDto(){{
            setId(roomEntity.getId());
            setName(roomEntity.getName());
            setDescription(roomEntity.getDescription());
        }}));
        return rooms;
    }

    public List<AccountRoomDto> getAccountRoomList(){
        List<AccountRoomDto> dtoRooms = new LinkedList<>();
        roomDao.getAccountRoomList().forEach(accountRoomEntity -> dtoRooms.add(new AccountRoomDto(){{
            setId(accountRoomEntity.getRoomId());
            setAccount1(accountRoomEntity.getAccount1());
            setAccount2(accountRoomEntity.getAccount2());
        }}));
        return dtoRooms;

    }

    public void joinRoom(Integer roomId, Integer accountId) {
        roomDao.joinRoom(roomId, accountId);
    }

    public void leaveRoom(Integer roomId, Integer accountId) {
        roomDao.leaveRoom(roomId, accountId);
    }
}