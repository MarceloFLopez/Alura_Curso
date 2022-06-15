package br.com.loja.testConnection;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.loja.model.Categoria;
import br.com.loja.model.Produto;
import br.com.loja.persistence.CategoriaDAO;
import br.com.loja.persistence.ProdutoDAO;
import br.com.loja.util.JPAUtil;

public class CadastroDeProdutos {

	public static void main(String[] args) {
		Categoria categoria= new  Categoria(null, "CELULARES");
		Produto celular = new Produto("Xaiomi Redme", "Muito Legal", new BigDecimal("800.00"), categoria);
	

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO pdao = new ProdutoDAO(em);
		CategoriaDAO cdao = new CategoriaDAO(em); 
		
		em.getTransaction().begin();
		cdao.cadastrar(categoria);
		pdao.cadastrar(celular);
		
		em.getTransaction().commit();
		
		Produto p = em.find(Produto.class,	 1l);
		System.out.println(p);
		em.close();

	}
}
