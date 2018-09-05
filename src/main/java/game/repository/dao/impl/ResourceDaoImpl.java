package game.repository.dao.impl;

import game.model.ResourceEntity;
import game.repository.dao.ResourceDao;
import game.repository.helper.QueryHelper;

import java.sql.*;
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

    public ResourceEntity getResource(int resourceId) {
        return new QueryHelper<ResourceEntity>() {
            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                ResourceEntity resourceEntity = new ResourceEntity();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM resource WHERE id = ?;");
                preparedStatement.setInt(1, resourceId);
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next()) {
                    resourceEntity.setId(rs.getInt("id"));
                    resourceEntity.setName(rs.getString("name"));
                    resourceEntity.setDescription(rs.getString("description"));
                }
                returnResult(resourceEntity);
            }
        }.run();    }
}
