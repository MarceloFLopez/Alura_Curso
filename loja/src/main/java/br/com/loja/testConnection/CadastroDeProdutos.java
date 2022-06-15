package br.com.loja.testConnection;

import javax.persistence.EntityManager;

import br.com.loja.model.Categoria;
import br.com.loja.util.JPAUtil;

public class CadastroDeProdutos {

	public static void main(String[] args) {
		Categoria categoria= new  Categoria(null, "CELULARES");

		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(categoria);
		em.getTransaction().commit();
		
		Categoria p = em.find(Categoria.class,	 1l);
		
		System.out.println(p);
		
		em.getTransaction().begin();
		em.persist(p);
		p.setNome("XPTO");
		em.getTransaction().commit();
		System.out.println(p);
		em.close();

	}
}
