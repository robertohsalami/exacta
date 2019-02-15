package br.com.exacta.apiexacta.client;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.exacta.apiexacta.entity.Gasto;

public class ClientApiExacta {
	
	public List<Gasto> listarTodos(){
		List<Gasto> gastos = new ArrayList<Gasto>();
		
		Client client = ClientBuilder.newClient();
		WebTarget base = client.target("http://localhost:8090/exacta-app/apiexacta");
		WebTarget lista = base.path("listarTodos");
		gastos = lista.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Gasto>>() {});
		
		return gastos;
	}
	
	public Gasto obterGasto(int idGasto) {		
		Client client = ClientBuilder.newClient();
		WebTarget base = client.target("http://localhost:8090/exacta-app/apiexacta");
		WebTarget gasto = base.path("{id}").resolveTemplate("id", idGasto);
		Gasto gastorPorId = gasto.request(MediaType.APPLICATION_JSON).get(Gasto.class);
		
		return gastorPorId;
	}
	
	public Response criarGasto(Gasto gasto) {
		Client client = ClientBuilder.newClient();
		WebTarget base = client.target("http://localhost:8090/exacta-app/apiexacta");
		WebTarget add = base.path("criarGasto");
		Response response = add.request(MediaType.APPLICATION_JSON).post(Entity.json(gasto));
		
		System.out.println("Response Http Status: "+ response.getStatus());
        System.out.println(response.getLocation());
        
	    client.close();
	    
	    return response;
		
	}	

	public static void main(String[] args) {
		ClientApiExacta client = new ClientApiExacta();
		//client.listarTodos();
		
		/*
		 * int idGasto = 1; Gasto gasto = client.obterGasto(idGasto);
		 * System.out.println(gasto.getNome());
		 */
		
		Gasto gasto = new Gasto();
		gasto.setNome("Nestor Vieira");
		gasto.setDataHora(Calendar.getInstance());
		gasto.setDescricao("Restaurante");
		gasto.setValor(new BigDecimal(33));
		gasto.setTags("Almoço pos reunião");
		client.criarGasto(gasto);
	}	

}
