package br.com.exacta.apiexacta.service;

import java.util.List;

import br.com.exacta.apiexacta.entity.Gasto;

public interface IGastoService {
	void criarGasto(Gasto gasto);

	List<Gasto> listarTodos();

	Gasto obterGasto(int idGasto);
}
