package br.com.loja.testConnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestConnection {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja");
		EntityManager em = emf.createEntityManager();
		System.out.println(em);
		em.close();
		System.out.println(em);
	}

}
