package br.com.turismo.dao;

import java.util.List;

import javax.persistence.EntityManager;

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
		return entityManager.getReference(Lugar.class, id);
	}

	public List<Lugar> listarLugar() {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		List<Lugar> lugares = manager.createQuery("SELECT l FROM Lugar AS l ORDER BY namePlace").getResultList();
		manager.close();
		return lugares;
	}
	

}
