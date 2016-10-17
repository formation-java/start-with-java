package fr.glouglouwine.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class GlouGlouServer {

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);

		ResourceConfig config = new ResourceConfig();
		config.packages("fr.glouglouwine", "com.jersey.jaxb", "com.fasterxml.jackson.jaxrs.json");

		ServletContextHandler context = new ServletContextHandler(server, "/*");

		ServletHolder baseServlet = new ServletHolder(new BaseServlet());
		context.addServlet(baseServlet, "/*");

		ServletHolder apiServlet = new ServletHolder(new ServletContainer(config));
		context.addServlet(apiServlet, "/api/*");

		server.start();
		// makes the main thread wait for server thread terminiation
		server.join();

	}

}
