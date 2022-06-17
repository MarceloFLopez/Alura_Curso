package br.com.loja.persistence;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.model.Categoria;
import br.com.loja.util.JPAUtil;

public class CategoriaDAO {
	private EntityManager em = JPAUtil.getEntityManager();

	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}

	// Atualizanddo objeto
	public void atualizar(Categoria categoria) {
		this.em.persist(categoria);
	}

	// removendo objeto
	public void remover(Categoria categoria) {
		categoria = em.merge(categoria);
		this.em.remove(categoria);
	}

	// Buscando por id e retornando um objeto
	public Categoria buscarPorId(Long id) {
		return em.find(Categoria.class, id);
	}

	// Buscando por nome e retornando uma lista de objetos
	public List<Categoria> buscarTodos() {
		String JPQL = "SELECT p FROM Categoria p";
		return em.createQuery(JPQL, Categoria.class).getResultList();
	}

	// Buscando por nome e retornando um objeto
	public Categoria buscarPorNome(String nome) {
		String JPQL = "SELECT p FROM Categoria p WHERE p.nome = :nome";
		return em.createQuery(JPQL, Categoria.class).setParameter("nome", nome).getSingleResult();
	}

	// Buscando por nome e retornando uma lista
	public List<Categoria> buscarPorCategoria(String nome) {
		String JPQL = "SELECT p FROM Categoria p WHERE p.categorias.nome = :nome";
		return em.createQuery(JPQL, Categoria.class).setParameter("nome", nome).getResultList();
	}

	// Consultando um atributo apartir de outro atributo
	public BigDecimal buscarPrecoDoCategoriaPorNome(String nome) {
		String JPQL = "SELECT p.preco FROM Categoria p WHERE p.nome = :nome";
		return em.createQuery(JPQL, BigDecimal.class).setParameter("nome", nome).getSingleResult();
	}
}
