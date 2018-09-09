package game.controller.impl;

import game.controller.ResourceController;
import game.dto.ResourceDto;
import game.service.ResourceService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/resource")
public class ResourceControllerImpl implements ResourceController {

    @Inject
    public ResourceService resourceService;

    @GET
    @Path("list")
    public List<ResourceDto> getAllResourceList() {
        return resourceService.getAllResourceList();
    }

    @GET
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ResourceDto getResource(@PathParam("id") Integer resourceId) {
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"resourceId=" + resourceId);
        return resourceService.getResource(resourceId);
    }
}
