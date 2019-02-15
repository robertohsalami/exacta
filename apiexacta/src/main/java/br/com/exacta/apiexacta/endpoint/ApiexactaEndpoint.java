package br.com.exacta.apiexacta.endpoint;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.exacta.apiexacta.entity.Gasto;
import br.com.exacta.apiexacta.service.IGastoService;

@Component
@Path("/apiexacta")
public class ApiexactaEndpoint {	
	
	@Autowired
	private IGastoService gastoService;
	
	@POST
	@Path("/criarGasto")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response criarGasto(Gasto gasto) {
		gastoService.criarGasto(gasto);
		return Response.created(URI.create("/exacta-app/apiexacta/"+ gasto.getId())).build();		
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterGasto(@PathParam("id") int id) {
		Gasto gasto = gastoService.obterGasto(id);
		return Response.ok(gasto).build();
	}
	
	@GET
	@Path("/listarTodos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		List<Gasto>  gasto = gastoService.listarTodos();
		return Response.ok(gasto).build();		
	}

}
