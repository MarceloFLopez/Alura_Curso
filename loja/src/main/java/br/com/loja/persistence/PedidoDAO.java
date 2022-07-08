package br.com.loja.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.model.Pedido;

public class PedidoDAO {

	private EntityManager em;

	// Criando uma fabria de conexões
	public PedidoDAO(EntityManager em) {
		this.em = em;
	}

	// Adicionando um novo objeto
	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}

	// Atualizanddo objeto
	public void atualizar(Pedido pedido) {
		this.em.persist(pedido);
	}

	// removendo objeto
	public void remover(Pedido pedido) {
		pedido = em.merge(pedido);
		this.em.remove(pedido);
	}

	// Buscando por id e retornando um objeto
	public Pedido buscarPorId(Long id) {
		return em.find(Pedido.class, id);
	}

	// Buscando por nome e retornando uma lista de objetos
	public List<Pedido> buscarTodos() {
		String JPQL = "SELECT p FROM Pedido p";
		return em.createQuery(JPQL, Pedido.class).getResultList();
	}

}
