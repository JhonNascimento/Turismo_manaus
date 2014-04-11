package br.com.turismo.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("turismo");

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
