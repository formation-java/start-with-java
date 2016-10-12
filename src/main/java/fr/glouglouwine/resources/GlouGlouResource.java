package fr.glouglouwine.resources;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.glouglouwine.services.GreetingStyle;
import fr.glouglouwine.services.GreetingService;

@Path("/glouglou")
public class GlouGlouResource {

	private Logger logger = Logger.getLogger(GlouGlouResource.class.getName());

	public GlouGlouResource() {
		logger.info("Resource initialized");
	}

	@GET
	@Path("hello/{msg}")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello(@PathParam("msg") String msg) {
		logger.info("You said " + msg + " hello in TEXT_PLAIN");
		return GreetingService.getInstance().getText(msg);
	}

	@GET
	@Path("hellojson/{msg}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response helloJson(@PathParam("msg") String msg) {
		logger.info("You said " + msg + " hello in JSON");
		return Response.status(200).entity(GreetingService.getInstance().getJson(msg)).build();
	}

	// @PUT should be the correct anotation, but we use get for demo purpose
	@GET
	@Path("mode/{greetingStyle}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setMode(@PathParam("greetingStyle") String greetingStyle) {
		logger.info("Setting greetingStyle to [" + greetingStyle + "]");
		GreetingService.getInstance().setGreetingStyle(GreetingStyle.valueOf(greetingStyle));
		return Response.status(204).build();
	}
}
