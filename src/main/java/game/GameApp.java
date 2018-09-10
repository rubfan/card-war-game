package game;

import java.util.logging.Level;
import java.util.logging.Logger;

import game.config.AppContextConfig;
import game.config.DeployDbConfig;
import org.eclipse.jetty.server.Server;

/**
 * @author ruslang.ramatic
 */
public class GameApp {

	public static void main(String[] args) throws Exception {
		if(args != null && args.length > 0) {
			switch (args[0]) {
				case "deploy":
					new DeployDbConfig().deployDb();
					break;
				case "start":
					Boolean debug = args.length > 1 && args[0].equals("debug");
					Integer port = args.length > 2 ? Integer.parseInt(args[1]) : 9090;
					startServer(debug, port);
					break;
				case "run":
					new DeployDbConfig().deployDb();
					startServer(false, 8080);
					break;
			}
		} else {
			throw new Exception("You need to use App arguments: start or deploy!");
		}
	}

	private static void startServer(Boolean debug, Integer port) {
		Server jettyServer = new Server(port);
		AppContextConfig appContext = new AppContextConfig();
		jettyServer.setHandler(appContext.getHandlersConfig());

		try {
			jettyServer.start();
			if(debug) jettyServer.dumpStdErr();
			jettyServer.join();
		} catch (Exception e) {
			Logger.getLogger(GameApp.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			jettyServer.destroy();
		}
	}
}