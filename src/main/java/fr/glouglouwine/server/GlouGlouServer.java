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

		ServletHolder servlet = new ServletHolder(new ServletContainer(config));

		ServletContextHandler context = new ServletContextHandler(server, "/api/*");
		context.addServlet(servlet, "/api/*");
		
		ServletHolder baseServlet = new ServletHolder(new BaseServlet());
		ServletContextHandler baseContext = new ServletContextHandler(server, "/*");
		baseContext.addServlet(baseServlet, "/*");
		
		server.start();
		// makes the main thread wait for server thread terminiation
		server.join();

	}

}
