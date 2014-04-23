package br.com.turismo.control.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import br.com.turismo.bean.Lugar;
import br.com.turismo.dao.LugarDAO;
import br.com.turismo.model.dao.JPAUtil;

public class LugarMB {
	private Lugar lugar = new Lugar();
	
	public Lugar getLugar(){
		return lugar;
	}
	
	public void setLugar(Lugar lugar){
		this.lugar = lugar;
	}
	

	// Atributo que guarda a colecao usuarios armazenadas em BD
	public List<Lugar> listaLugares = new ArrayList<Lugar>();

	public List<Lugar> getListaLugares() {
		return listaLugares;
	}

	@PostConstruct
	public void carregarLugar() {
		EntityManager manager = JPAUtil.getEntityManager();
		LugarDAO dao = new LugarDAO(manager);
		listaLugares = dao.listarLugar();
		manager.close();
	}

	public void Excluir() {
		EntityManager manager = JPAUtil.getEntityManager();
		LugarDAO dao = new LugarDAO(manager);
		manager.getTransaction().begin();
		Lugar encontrado = dao.buscar(lugar.getId());
		dao.remover(encontrado);
		manager.getTransaction().commit();
		manager.close();
//		carregarLugar();
	}

	public void Salvar() {
		EntityManager em = JPAUtil.getEntityManager();
		LugarDAO dao = new LugarDAO(em);
		em.getTransaction().begin();

		if (lugar.getId() != null) {
			dao.alterar(lugar);
		} else {
			dao.cadastrar(lugar);
		}
		em.getTransaction().commit();
		em.close();
		lugar = new Lugar();
//		carregarLugar();
	}

}
