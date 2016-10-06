package fr.blablacar;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/blabla")
public class HelloBlaBlaCar {

	Logger logger = Logger.getLogger(HelloBlaBlaCar.class.getName());
	
	@GET
	@Path("hello/{msg}")
	@Produces(MediaType.TEXT_PLAIN)
	public String blablaSaid(@PathParam("msg") String msg) {
		logger.info("blablaSaid");
		return "BlaBla said " + msg;
	}

	@GET
	@Path("hellojson/{msg}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response blablaJsonSaid(@PathParam("msg") String msg) {
		logger.info("blablaJsonSaid");
		HelloBlaBla helloBlaBla = new HelloBlaBla();
		helloBlaBla.message = msg;
		return Response.status(201).entity(helloBlaBla).build();
	}
}
