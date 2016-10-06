import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class BlaBlaServer {
	
	public static void main(String[] args) throws Exception
    {
		Server server = new Server(8080);

		ResourceConfig config = new ResourceConfig();
		 config.packages("fr.blablacar","com.jersey.jaxb","com.fasterxml.jackson.jaxrs.json");
		 ServletHolder servlet = new ServletHolder(new ServletContainer(config));

		 ServletContextHandler context = new ServletContextHandler(server, "/*");
		 context.addServlet(servlet, "/*");




        // Start things up!
        server.start();

        // The use of server.join() the will make the current thread join and
        // wait until the server is done executing.
        // See
        // http://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#join()
        server.join();
    }
	
}
