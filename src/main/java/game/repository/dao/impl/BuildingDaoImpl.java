package game.repository.dao.impl;

import game.model.BuildingEntity;
import game.repository.dao.BuildingDao;
import game.repository.helper.QueryHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class BuildingDaoImpl implements BuildingDao {

    @Override
    public List<BuildingEntity> getAllBuildingList() {
        return new QueryHelper<List<BuildingEntity>>(){

            @Override
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                List<BuildingEntity> buildingEntityList = new LinkedList<>();
                ResultSet rs = statement.executeQuery("SELECT * FROM building b " +
                        "JOIN building_resource br on b.id = br.building_id " +
                        "JOIN resource r on r.id = b.resource_id;");
                while (rs.next()){
                    BuildingEntity buildingEntity = new BuildingEntity();
                    buildingEntity.setId(rs.getInt("id"));
                    buildingEntity.setName(rs.getString("name"));
                    buildingEntity.setDescription(rs.getString("description"));
                    buildingEntityList.add(buildingEntity);
                }
                returnResult(buildingEntityList);
            }
        }.run();
    }
}
