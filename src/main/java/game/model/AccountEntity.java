package game.model;

import game.dto.RoomDto;
import game.dto.UserDto;

import java.io.Serializable;
import java.util.Date;

public class AccountEntity implements Serializable {
    private Integer id;
    private UserDto user;
    private RoomDto room;
    private Date startGameTime;

    public AccountEntity(Integer id, UserDto user, RoomDto room, Date startGameTime) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.startGameTime = startGameTime;
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

    public Date getStartGameTime() {
        return startGameTime;
    }

    public void setStartGameTime(Date startGameTime) {
        this.startGameTime = startGameTime;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", user=" + user +
                ", room=" + room +
                ", startGameTime=" + startGameTime +
                '}';
    }
}
