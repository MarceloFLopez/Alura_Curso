package br.com.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory FACOTORY = Persistence.createEntityManagerFactory("loja");
	
	public static EntityManager getEntityManager() {
		return FACOTORY.createEntityManager();
	}
}
