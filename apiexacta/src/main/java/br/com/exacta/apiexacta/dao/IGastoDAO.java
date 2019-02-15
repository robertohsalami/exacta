package br.com.exacta.apiexacta.dao;

import java.util.List;

import br.com.exacta.apiexacta.entity.Gasto;

public interface IGastoDAO {
	void criarGasto(Gasto gasto);

	List<Gasto> listarTodos();

	Gasto obterGasto(int idGasto);
}
