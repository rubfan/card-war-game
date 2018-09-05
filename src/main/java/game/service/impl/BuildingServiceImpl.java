package game.service.impl;

import game.dto.BuildingDto;
import game.repository.dao.BuildingDao;
import game.service.BuildingService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class BuildingServiceImpl implements BuildingService {

    @Inject
    BuildingDao buildingDao;

    @Override
    public List<BuildingDto> getAllBuildingList() {
        final List<BuildingDto> buildings = new LinkedList<>();
        buildingDao.getAllBuildingList().forEach(buildingEntity -> {
            buildings.add(new BuildingDto(){{
                setId(buildingEntity.getId());
                setName(buildingEntity.getName());
                setDescription(buildingEntity.getDescription());
            }});
        });
        return buildings;
    }
}