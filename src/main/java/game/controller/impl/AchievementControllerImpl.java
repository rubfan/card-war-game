package game.controller.impl;

import game.controller.AchievementController;
import game.dto.AchievementDto;
import game.service.AchievementService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/achievements")
public class AchievementControllerImpl implements AchievementController {

    @Inject
    private AchievementService achievementService;

    @Override
    @GET
    @Path("/list")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<AchievementDto> getAllAchievementList() {
        return achievementService.getAllAchievementList();
    }
}
