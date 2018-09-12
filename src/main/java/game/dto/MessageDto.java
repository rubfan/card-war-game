package game.dto;

import game.model.MessageEntity;

import java.util.Date;

/**
 * @author ruslan.gramatic
 */
public class MessageDto {
    private Integer id;
    private String text;
    private Integer fromAccountId;
    private Integer toAccountId;
    private Date time;

    public MessageDto(MessageEntity messageEntity) {
        this.id = messageEntity.getId();
        this.text = messageEntity.getText();
        this.fromAccountId = messageEntity.getFromAccountId();
        this.toAccountId = messageEntity.getToAccountId();
        this.time = messageEntity.getTime();
    }

    public MessageDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Integer fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Integer getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Integer toAccountId) {
        this.toAccountId = toAccountId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", fromAccountId=" + fromAccountId +
                ", toAccountId=" + toAccountId +
                ", time=" + time +
                '}';
    }
}


