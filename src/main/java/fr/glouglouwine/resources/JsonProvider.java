package fr.glouglouwine.resources;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;

@Provider
public class JsonProvider implements ContextResolver<ObjectMapper> {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	public ObjectMapper getContext(Class<?> type) {
		return MAPPER;
	}

}