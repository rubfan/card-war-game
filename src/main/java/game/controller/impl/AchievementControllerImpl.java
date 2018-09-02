package game.controller.impl;

import game.controller.AchievementController;
import game.dto.AchievementDto;
import game.service.AchievementService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/achievement")
public class AchievementControllerImpl implements AchievementController {

    @Inject
    private AchievementService achievementService;

    @GET
    @Path("/list")
    @Override
    public List<AchievementDto> getAllAchievementList() {
        return achievementService.getAllAchievementList();
    }
}
