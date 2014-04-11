package br.com.turismo.dao.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.turismo.bean.Usuario;
import br.com.turismo.dao.UsuarioDAO;
import br.com.turismo.model.dao.JPAUtil;

public class UsuarioDAOTest {

	@Test
	public void testUsuarioDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testCadastrar() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		
		Usuario user = new Usuario();
		
		user.setName("Tiago");
		user.setEmail("tiagomoura@gmail.com");
		user.setPassword("123");
		
//		entityManager.getTransaction().begin();
//		dao.cadastrar(user);
//		entityManager.getTransaction().commit();
//		entityManager.close();
	}
	
	@Test
	public void testBuscar(){
		EntityManager entityManager = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		
		entityManager.getTransaction().begin();
		dao.buscar(9L);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Test
	public void testAlterar() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		
		entityManager.getTransaction().begin();
		Usuario encontrado = dao.buscar(8L);
		encontrado.setName("Joao");
		encontrado.setEmail("joao@gmail.com");
		encontrado.setPassword("654786");
		dao.alterar(encontrado);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	

}
