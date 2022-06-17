package br.com.loja.persistence;

import java.math.BigDecimal;
<<<<<<< Updated upstream
=======
import java.time.LocalDate;
>>>>>>> Stashed changes
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.loja.model.Produto;

public class ProdutoDao {

	private EntityManager em;

<<<<<<< Updated upstream
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
=======
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}

	public void atualizar(Produto produto) {
		this.em.merge(produto);
	}

>>>>>>> Stashed changes
	public void remover(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
	}
	
<<<<<<< Updated upstream
	// Buscando por id e retornando um objeto
=======
>>>>>>> Stashed changes
	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);
	}
	
<<<<<<< Updated upstream
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
	
=======
	public List<Produto> buscarTodos() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}
	
	public List<Produto> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public List<Produto> buscarPorNomeDaCategoria(String nome) {
		return em.createNamedQuery("Produto.produtosPorCategoria", Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public BigDecimal buscarPrecoDoProdutoComNome(String nome) {
		String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, BigDecimal.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}
	
	public List<Produto> buscarPorParametros(String nome, 
			BigDecimal preco, LocalDate dataCadastro) {
		String jpql = "SELECT p FROM Produto p WHERE 1=1 ";
		if (nome != null && !nome.trim().isEmpty()) {
			jpql = " AND p.nome = :nome ";
		}
		if (preco != null) {
			jpql = " AND p.preco = :preco ";
		}
		if (dataCadastro != null) {
			jpql = " AND p.dataCadastro = :dataCadastro ";
		}
		TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);
		if (nome != null && !nome.trim().isEmpty()) {
			query.setParameter("nome", nome);
		}
		if (preco != null) {
			query.setParameter("preco", preco);
		}
		if (dataCadastro != null) {
			query.setParameter("dataCadastro", dataCadastro);
		}
		
		return query.getResultList();
	}
	
	public List<Produto> buscarPorParametrosComCriteria(String nome, 
			BigDecimal preco, LocalDate dataCadastro) {
	
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
		Root<Produto> from = query.from(Produto.class);
		
		Predicate filtros = builder.and();
		if (nome != null && !nome.trim().isEmpty()) {
			filtros = builder.and(filtros, builder.equal(from.get("nome"), nome));
		}
		if (preco != null) {
			filtros = builder.and(filtros, builder.equal(from.get("preco"), preco));
		}
		if (dataCadastro != null) {
			filtros = builder.and(filtros, builder.equal(from.get("dataCadastro"), dataCadastro));
		}
		query.where(filtros);
		
		return em.createQuery(query).getResultList();
	}
>>>>>>> Stashed changes
	
}
