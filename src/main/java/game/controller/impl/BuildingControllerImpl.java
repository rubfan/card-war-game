package game.controller.impl;

import game.controller.BuildingController;
import game.dto.BuildingDto;
import game.service.BuildingService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/building")
public class BuildingControllerImpl implements BuildingController {

    @Inject
    public BuildingService buildingService;

    @GET
    @Path("list")
    public List<BuildingDto> getAllBuildingList() {
        return buildingService.getAllBuildingList();

    }
}
