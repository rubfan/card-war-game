package game.model;

import game.dto.AccountDto;

import java.io.Serializable;

public class AccountRoomEntity implements Serializable {
    private Integer roomId;
    private AccountDto account1;
    private AccountDto account2;

    public AccountRoomEntity(Integer roomId, AccountDto account1, AccountDto account2) {
        this.roomId = roomId;
        this.account1 = account1;
        this.account2 = account2;
    }

    public AccountRoomEntity() {

    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public AccountDto getAccount1() {
        return account1;
    }

    public void setAccount1(AccountDto account1) {
        this.account1 = account1;
    }

    public AccountDto getAccount2() {
        return account2;
    }

    public void setAccount2(AccountDto account2) {
        this.account2 = account2;
    }

    @Override
    public String toString() {
        return "AccountRoomEntity{" +
                "roomId=" + roomId +
                ", account1=" + account1 +
                ", account2=" + account2 +
                '}';
    }
}
