package br.com.exacta.apiexacta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.exacta.apiexacta.dao.IGastoDAO;
import br.com.exacta.apiexacta.entity.Gasto;

@Service
public class GastoService implements IGastoService {
	
	@Autowired
	private IGastoDAO igastoDAO;

	@Override
	public void criarGasto(Gasto gasto) {
		igastoDAO.criarGasto(gasto);
	}

	@Override
	public List<Gasto> listarTodos() {
		return igastoDAO.listarTodos();
	}

	@Override
	public Gasto obterGasto(int idGasto) {
		return igastoDAO.obterGasto(idGasto);
	}

}
