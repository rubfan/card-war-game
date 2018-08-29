package game.controller.impl;

import game.controller.ResourceController;
import game.dto.ResourceDto;
import game.service.ResourceService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/resource")
public class ResourceControllerImpl implements ResourceController {

    @Inject
    public ResourceService resourceService;

    @GET
    @Path("list")
    public List<ResourceDto> getAllResourceList() {
        return resourceService.getAllResourceList();
    }
}
