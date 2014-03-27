package br.com.turismo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.turismo.bean.Lugar;
import br.com.turismo.model.dao.JPAUtil;

public class LugarDAO {
	private EntityManager entityManager;

	public LugarDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void cadastrar(Lugar lugar) {
		entityManager.persist(lugar);
	}

	public void alterar(Lugar lugar) {
		entityManager.merge(lugar);
	}

	public void remover(Lugar lugar) {
		entityManager.remove(lugar);
	}

	public Lugar buscar(Long id) {
		return entityManager.find(Lugar.class, id);
	}

	public List<Lugar> listarLugar() {
		EntityManager manager = JPAUtil.getEntityManager();
		String jpql = "SELECT l FROM Lugar as l ORDER BY namePlace";
		Query query = manager.createQuery(jpql);
		return query.getResultList();
	}

}
