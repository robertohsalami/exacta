package br.com.exacta.clientapi;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ClientApiExacta {

	private Client client;

	private WebTarget webTarget;

	private final String URL_SERVICE = "http://localhost:8090/exacta-app/apiexacta/";

	public ClientApiExacta() {
		this.client = ClientBuilder.newClient();
	}

	public Response criarGasto(Gasto gasto) {

		this.webTarget = this.client.target(URL_SERVICE).path("criarGasto");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.post(Entity.entity(gasto, "application/json;charset=UTF-8"));

		return response;

	}

	public Gastos listarTodos() {

		this.webTarget = this.client.target(URL_SERVICE).path("listarTodos");

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.get();

		return response.readEntity(Gastos.class);

	}

	public Gasto obterGasto(int idGasto) {

		this.webTarget = this.client.target(URL_SERVICE).path("{id}").resolveTemplate("id", idGasto);

		Invocation.Builder invocationBuilder = this.webTarget.request("application/json;charset=UTF-8");

		Response response = invocationBuilder.get();

		return response.readEntity(Gasto.class);

	}

}
