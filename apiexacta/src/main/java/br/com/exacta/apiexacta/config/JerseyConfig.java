package br.com.exacta.apiexacta.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import br.com.exacta.apiexacta.endpoint.ApiexactaEndpoint;

@Component
@ApplicationPath("/exacta-app")
public class JerseyConfig extends ResourceConfig{
	public JerseyConfig() {
		register(ApiexactaEndpoint.class);		
	}
}
