package br.com.exacta.clientapi;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.ws.rs.core.Response;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ClientApiExacta serviceClient = new ClientApiExacta();

//		Gasto criarGasto = new Gasto();
//		criarGasto.setNome("Marilia Pera");
//		criarGasto.setDataHora(Calendar.getInstance());
//		criarGasto.setDescricao("Projac");
//		criarGasto.setValor(new BigDecimal(45));
//		criarGasto.setTags("Minuto pago");
//		Response response = serviceClient.criarGasto(criarGasto);
//		System.out.println("Teste Criar Gasto");		
//		System.out.println("Response Http Status: " + response.getStatus());
//		System.out.println(response.getLocation());
//
//		Gastos listarTodos = serviceClient.listarTodos();
//		System.out.println("Teste Listar todos os Gastos");
//		for (Gasto gasto : listarTodos) {
//			System.out.println(gasto.getId());
//		}		

		Gasto gasto = serviceClient.obterGasto(2);
		System.out.println("Listar Gasto por Id");
		System.out.println(gasto.getNome());
		System.out.println(gasto.getDescricao());
		System.out.println(gasto.getDataHora());
		
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateFormatted = fmt.format(gasto.getDataHora().getTime());
        System.out.println(dateFormatted);
	}
}
