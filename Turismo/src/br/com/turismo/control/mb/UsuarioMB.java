package br.com.turismo.control.mb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import br.com.turismo.bean.Usuario;
import br.com.turismo.dao.UsuarioDAO;
import br.com.turismo.model.dao.JPAUtil;

@ViewScoped
@ManagedBean
public class UsuarioMB {

	// Atributos devem ser iniciados
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	// Atributo que guarda a colecao usuarios armazenadas em BD
	public List<Usuario> listaUsuarios = new ArrayList<Usuario>();

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	@PostConstruct
	public void carregarUsuarios() {
		EntityManager manager = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(manager);
		listaUsuarios = dao.listar();
		manager.close();
	}

	public void excluir() {
		EntityManager manager = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(manager);
		manager.getTransaction().begin();
		Usuario encontrado = dao.buscar(usuario.getId());
		dao.remover(encontrado);
		manager.getTransaction().commit();
		manager.close();
		carregarUsuarios();
	}

	public void salvar() {
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);
		em.getTransaction().begin();

		if (usuario.getId() != null) {
			dao.alterar(usuario);
		} else {
			dao.cadastrar(usuario);
		}
		em.getTransaction().commit();
		em.close();
		usuario = new Usuario();
		carregarUsuarios();
	}
}
