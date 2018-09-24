package game.dto;

import java.util.Date;

/**
 * @author ruslan.gramatic
 */
public class AccountDto {
    private Integer id;
    private UserDto user;
    private RoomDto room;

    public AccountDto() {}

    public AccountDto(Integer id, UserDto user, RoomDto room, Date startGameTime) {
        this.id = id;
        this.user = user;
        this.room = room;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public RoomDto getRoom() {
        return room;
    }

    public void setRoom(RoomDto room) {
        this.room = room;
    }



    @Override
    public String toString() {
        return "AccountDto{" +
                "id=" + id +
                ", user=" + user +
                ", room=" + room +
                '}';
    }
}