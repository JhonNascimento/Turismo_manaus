package br.com.turismo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.turismo.bean.Usuario;
import br.com.turismo.model.dao.JPAUtil;

public class UsuarioDAO {

	private EntityManager entityManager;

	public UsuarioDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void cadastrar(Usuario usuario) {
		entityManager.persist(usuario);
	}

	public Usuario buscar(Long id) {
		return entityManager.getReference(Usuario.class, id);
	}

	public void alterar(Usuario usuario) {
		entityManager.merge(usuario);
	}

	public void remover(Usuario usuario) {
		entityManager.remove(usuario);
	}

	// @SuppressWarnings("unchecked")
	// public List<Usuario> listar() {
	// EntityManager manager = JPAUtil.getEntityManager();
	// String jpql = "Select p from Usuario as p ORDER BY p.name";
	// Query query = manager.createQuery(jpql);
	// return query.getResultList();
	// }

	public List<Usuario> listar() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		List<Usuario> usuarios = entityManager.createQuery(
				"SELECT t FROM Usuario AS t ORDER BY t.name").getResultList();
		entityManager.close();
		return usuarios;
	}
}

// #outro metodo
// UsuarioDAO dao = new UsuarioDAO(manager);
// List<Usuario> lista =
// manager.createQuery("SELECT p FROM Usuario AS p").getResultList();
// for (Usuario usuario : lista) {
// System.out.println(usuario.getName());
// }

// #outro metodo