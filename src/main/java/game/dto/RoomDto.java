package game.dto;

import java.util.Date;

/**
 * @author ruslan.gramatic
 */
public class RoomDto {
    private Integer id;
    private String name;
    private String description;
    private Date startGameTime;

    public RoomDto(Integer id, String name, String description, Date startGameTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startGameTime = startGameTime;
    }

    public RoomDto() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartGameTime() {
        return startGameTime;
    }

    public void setStartGameTime(Date startGameTime) {
        this.startGameTime = startGameTime;
    }
    @Override
    public String toString() {
        return "RoomDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startGameTime='" + startGameTime + '\'' +
                '}';
    }
}
