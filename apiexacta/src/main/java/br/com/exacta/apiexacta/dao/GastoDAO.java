package br.com.exacta.apiexacta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.exacta.apiexacta.entity.Gasto;

@Transactional
@Repository
public class GastoDAO implements IGastoDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void criarGasto(Gasto gasto) {
		em.persist(gasto);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Gasto> listarTodos() {
		String hql = "FROM Gasto as g";
		return (List<Gasto>) em.createQuery(hql).getResultList();
	}

	@Override
	public Gasto obterGasto(int idGasto) {
		return em.find(Gasto.class, idGasto);
	}

}
