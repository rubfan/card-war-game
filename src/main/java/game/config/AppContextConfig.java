package game.config;

import game.controller.AccountUpgradeController;
import game.controller.RoomController;
import game.controller.UpgradeController;
import game.controller.UserController;
import game.controller.impl.AccountUpgradeControllerImpl;
import game.controller.impl.RoomControllerImpl;
import game.controller.impl.UpgradeControllerImpl;
import game.controller.impl.UserControllerImpl;
import game.repository.dao.*;
import game.repository.dao.impl.*;
import game.service.*;
import game.service.impl.*;
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
            packages(true,"game");
            register(new AbstractBinder() {
                @Override
                protected void configure () {
                    bindAsContract(RoomDaoImpl.class).to(RoomDao.class);
                    bindAsContract(RoomServiceImpl.class).to(RoomService.class);
                    bindAsContract(RoomControllerImpl.class).to(RoomController.class);

                    bindAsContract(UpgradeDaoImpl.class).to(UpgradeDao.class);
                    bindAsContract(UpgradeServiceImpl.class).to(UpgradeService.class);
                    bindAsContract(UpgradeControllerImpl.class).to(UpgradeController.class);

                    bindAsContract(UpgradeBuildingDaoImpl.class).to(UpgradeBuildingDao.class);
                    bindAsContract(UpgradeBuildingServiceImpl.class).to(UpgradeBuildingService.class);

                    bindAsContract(AccountUpgradeDaoImpl.class).to(AccountUpgradeDao.class);
                    bindAsContract(AccountUpgradeServiceImpl.class).to(AccountUpgradeService.class);
                    bindAsContract(AccountUpgradeControllerImpl.class).to(AccountUpgradeController.class);


                        bindAsContract(UserDaoImpl.class).to(UserDao.class);
                    bindAsContract(UserServiceImpl.class).to(UserService.class);
                    bindAsContract(UserControllerImpl.class).to(UserController.class);
                }
            });
        }};
    }
}
