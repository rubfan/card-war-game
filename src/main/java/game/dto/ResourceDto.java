<<<<<<< HEAD
package game.dto;

/**
 * @author ruslan.gramatic
 */
public class ResourceDto {
    private Integer id;
    private String name;
    private String description;
}
=======
package game.dto;

/**
 * @author ruslan.gramatic
 */
public class ResourceDto {
    private Integer id;
    private String name;
    private String description;

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

    @Override
    public String toString() {
        return "ResourceDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
>>>>>>> 91d6f6686cd30cb97a1f73b6f5c03600d5adbc0f
