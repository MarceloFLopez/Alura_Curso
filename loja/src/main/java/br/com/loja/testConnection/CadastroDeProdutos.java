package br.com.loja.testConnection;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.loja.model.Categoria;
import br.com.loja.model.Produto;
import br.com.loja.persistence.ProdutoDAO;
import br.com.loja.util.JPAUtil;

public class CadastroDeProdutos {

	public static void main(String[] args) {
		cadatrarProdutos();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO(em);
		em.getTransaction().begin();
		
		
		em.getTransaction().commit();
		

		// Carreganddo uma lista
//		List<Produto>produtos = dao.buscarTodos();
//		produtos.forEach(a -> System.out.println(a.getNome()));

		// Buscando por ID
//		Produto p2 = dao.buscarPorId(2l);
//		System.out.println(p2);

		// Buscando por nome
//		Produto p2 = dao.buscarPorNome("Xiaomi Redmi");
//		System.out.println(p2);

		// Recuperando e Atualizando
//		List<Produto>produtos = dao.buscarTodos();
//		produtos.forEach(p -> System.out.println(p));
//		Produto p2 = dao.buscarPorId(2l);
//		p2.setDescricao("Muito TOP");
//		p2.setNome("Samsumg Galaxy V");
//		p2.setPreco(new BigDecimal(1500.00));
//		dao.atualizar(p2);
//		System.err.println("--------------");
//		List<Produto>produtos1 = dao.buscarTodos();
//		produtos1.forEach(p -> System.out.println(p));

		// Recuperanddo uma lista consultando suas categorias
//		List<Produto> todos = dao.buscarPorCategoria("Celulares");		
//		todos.forEach(p -> System.out.println(p.getNome()));

		BigDecimal p2 = dao.buscarPrecoDoProdutoPorNome("Xiaomi Redmi");
		System.out.println(p2);
		em.close();

	}

	public static void cadatrarProdutos() {
		Categoria a = new Categoria(null, "Celulares");
		Categoria a1 = new Categoria(null, "Eletrodomésticos");

		Produto produto = new Produto("Xiaomi Redmi", "Celular TOP", new BigDecimal(800.00), a);
		Produto produto1 = new Produto("Samsumg Galaxy", "Celular TOP", new BigDecimal(1800.00), a);

		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(produto);
		em.persist(produto1);
		em.persist(a);
		em.persist(a1);
		em.getTransaction().commit();
	}
}
