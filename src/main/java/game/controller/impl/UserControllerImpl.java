package game.controller.impl;

import game.controller.UserController;
import game.dto.UserDto;
import game.repository.dao.AccountDao;
import game.repository.dao.impl.AccountDaoImpl;
import game.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ruslan.gramatic
 */
@Path("/user")
public class UserControllerImpl implements UserController {

    @Inject
    public UserService userService;

    @POST
    @Path("login")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response loginUser(UserDto user) {
        String token = userService.getTokenByUserId(user);
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, user.toString());
        Cookie preCookie = new Cookie("token", token, "/", "", 1);
        NewCookie newCookie = new NewCookie(preCookie, "Added cookie and logged in", -1, false);
        return Response.ok().cookie(newCookie).build();
    }

    @GET
    @Path("logout")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response logoutUser(@CookieParam("token") Cookie cookie) {
        userService.logoutUser(cookie.getValue());
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, cookie.getValue());
        if (cookie != null) {
            Cookie preCookie = new Cookie("token", "", "/", "", 1);
            NewCookie newCookie = new NewCookie(preCookie, "Deleted cookie and logged out", -1, false);
            return Response.ok().cookie(newCookie).build();
        } else
            return Response.noContent().build();

    }

    @GET
    @Path("get/{userid}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public UserDto getUser(@PathParam("userid")Integer userId){
        return userService.getUserById(userId);
    }


    @POST
    @Path("new")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createNewUser(UserDto user) {
        String token = userService.getTokenByUserId(user);
        if(token == null) {
            token = userService.createNewUser(user);
        }
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, user.toString());
        Cookie preCookie = new Cookie("token", token, "/", "", 1);
        NewCookie newCookie = new NewCookie(preCookie, "Created new user and logged in/Or login if this user is exist", -1, false);
        return Response.status(201).entity("User").cookie(newCookie).build();
    }

}
