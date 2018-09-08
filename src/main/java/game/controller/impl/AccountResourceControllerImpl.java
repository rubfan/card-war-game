package game.controller.impl;

import game.controller.AccountResourceController;
import game.dto.AccountResourceDto;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/accountresource/")
public class AccountResourceControllerImpl implements AccountResourceController {

        @Inject
        public AccountResourseService

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
