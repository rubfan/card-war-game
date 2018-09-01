package game.config;

import game.controller.AccountController;
import game.controller.MessageController;
import game.controller.RoomController;
import game.controller.UserController;
import game.controller.impl.AccountControllerImpl;
//import game.controller.impl.MessageControllerImpl;
import game.controller.impl.MessageControllerImpl;
import game.controller.impl.RoomControllerImpl;
import game.controller.impl.UserControllerImpl;
import game.repository.dao.AccountDao;
import game.repository.dao.MessageDao;
import game.repository.dao.RoomDao;
import game.repository.dao.UserDao;
import game.repository.dao.impl.AccountDaoImpl;
import game.repository.dao.impl.MessageDaoImpl;
import game.repository.dao.impl.RoomDaoImpl;
import game.repository.dao.impl.UserDaoImpl;
import game.service.AccountService;
import game.service.MessageService;
import game.service.RoomService;
import game.service.UserService;
import game.service.impl.AccountServiceImpl;
import game.service.impl.MessageServiceImpl;
import game.service.impl.RoomServiceImpl;
import game.service.impl.UserServiceImpl;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.eclipse.jetty.util.resource.Resource;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.EnumSet;

/**
 * @autor ruslan.gramatic
 */
public class AppContextConfig {
    public HandlerList getHandlersConfig() {
        ServletContextHandler servletsHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        servletsHandler.setContextPath("/");
        servletsHandler.addServlet(new ServletHolder(new ServletContainer(getResourceConfig())), "/rest/*");

        FilterHolder holder = new FilterHolder(new CrossOriginFilter());
        holder.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,POST,HEAD,OPTIONS");
        servletsHandler.addFilter(holder, "/rest/*", EnumSet.of(DispatcherType.REQUEST));

        ResourceHandler resourceHandler = getResourceHandler();
        resourceHandler.setWelcomeFiles(new String[]{"login.html"});
        resourceHandler.setBaseResource(Resource.newClassPathResource("/webapp"));

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, servletsHandler});
        return handlers;
    }

    private ResourceHandler getResourceHandler(){
        return new ResourceHandler(){
            @Override
            public void handle(String target, Request baseRequest, HttpServletRequest request,
                               HttpServletResponse response) throws IOException, ServletException {
                if(target.equals("/rooms.html")
                        || target.equals("/achievements.html")
                        || target.equals("/gameplay.html")) {
                    Boolean flag = true;
                    for (Cookie cookie : request.getCookies()) {
                        if ("token".equals(cookie.getName())) {
                            flag = false;
                            if (cookie.getValue() == null || cookie.getValue().equals("")) {
                                flag = true;
                            }
                            break;
                        }
                    }
                    if (flag) {
                        response.sendRedirect("/login.html");
                    }
                }
                super.handle(target, baseRequest, request, response);
            }
        };
    }

    private ResourceConfig getResourceConfig() {
        return new ResourceConfig() {{
            packages("game");
            register(new AbstractBinder() {
                @Override
                protected void configure () {
                    bindAsContract(RoomDaoImpl.class).to(RoomDao.class);
                    bindAsContract(RoomServiceImpl.class).to(RoomService.class);
                    bindAsContract(RoomControllerImpl.class).to(RoomController.class);

                    bindAsContract(UserDaoImpl.class).to(UserDao.class);
                    bindAsContract(UserServiceImpl.class).to(UserService.class);
                    bindAsContract(UserControllerImpl.class).to(UserController.class);

                    bindAsContract(AccountDaoImpl.class).to(AccountDao.class);
                    bindAsContract(AccountServiceImpl.class).to(AccountService.class);
                    bindAsContract(AccountControllerImpl.class).to(AccountController.class);

                    bindAsContract(MessageDaoImpl.class).to(MessageDao.class);
                    bindAsContract(MessageServiceImpl.class).to(MessageService.class);
                    bindAsContract(MessageControllerImpl.class).to(MessageController.class);

                }
            });
        }};
    }
}
