package br.com.turismo.dao.test;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.turismo.dao.UsuarioDAO;
import br.com.turismo.model.dao.JPAUtil;

/**
 * @author tgx
 */
public class UsuarioDAOTest2 {

	@Test
	public void testListar() {
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);

		em.getTransaction().begin();
		dao.listar();
		em.getTransaction().commit();
		em.close();
	}

}
