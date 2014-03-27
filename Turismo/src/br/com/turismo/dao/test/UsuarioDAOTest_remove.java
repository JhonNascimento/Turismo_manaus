package br.com.turismo.dao.test;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.turismo.bean.Usuario;
import br.com.turismo.dao.UsuarioDAO;
import br.com.turismo.model.dao.JPAUtil;

public class UsuarioDAOTest_remove {

	@Test
	public void testRemover() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		
		entityManager.getTransaction().begin();
		Usuario deleteUser = dao.buscar(1l);
		dao.remover(deleteUser);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
