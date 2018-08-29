package game.repository.dao.impl;

import game.model.ResourceEntity;
import game.repository.dao.ResourceDao;
import game.repository.helper.QueryHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ResourceDaoImpl implements ResourceDao {

    @Override
    public List<ResourceEntity> getAllResourceList() {
        return new QueryHelper<List<ResourceEntity>>() {
            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<ResourceEntity> resourceDtoList= new LinkedList<>();
                ResultSet rs = statement.executeQuery("SELECT * FROM resource;");
                while(rs.next()) {
                    ResourceEntity resource = new ResourceEntity();
                    resource.setId(rs.getInt("id"));
                    resource.setName(rs.getString("name"));
                    resource.setDescription(rs.getString("description"));
                    resourceDtoList.add(resource);
                }
                returnResult(resourceDtoList);
            }
        }.run();
    }
}
