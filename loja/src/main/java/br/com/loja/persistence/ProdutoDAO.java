package br.com.loja.persistence;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.model.Produto;

public class ProdutoDAO {

	private EntityManager em;

	// Criando uma fabria de conexões
	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}
	
	// Adicionando um novo objeto
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	
	// Atualizanddo objeto
	public void atualizar(Produto produto) {
		this.em.persist(produto);
	}
	
	// removendo objeto
	public void remover(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
	}
	
	// Buscando por id e retornando um objeto
	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);
	}
	
	// Buscando por nome e retornando uma lista de objetos
	public List<Produto> buscarTodos(){
		String JPQL = "SELECT p FROM Produto p";
		return em.createQuery(JPQL,Produto.class).getResultList();		
	}
	
	// Buscando por nome e retornando um objeto
	public Produto buscarPorNome(String nome){
		String JPQL = "SELECT p FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(JPQL,Produto.class)
				 .setParameter("nome", nome).getSingleResult();		
	}
	
	// Buscando por nome e retornando uma lista
	public List<Produto> buscarPorCategoria(String nome){
		String JPQL = "SELECT p FROM Produto p WHERE p.categorias.nome = :nome";
		return em.createQuery(JPQL,Produto.class)
				 .setParameter("nome", nome).getResultList();		
	}
	
	// Consultando um atributo apartir de outro atributo
		public BigDecimal buscarPrecoDoProdutoPorNome(String nome){
			String JPQL = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
			return em.createQuery(JPQL,BigDecimal.class)
					 .setParameter("nome", nome).getSingleResult();		
	}
	
	
}
