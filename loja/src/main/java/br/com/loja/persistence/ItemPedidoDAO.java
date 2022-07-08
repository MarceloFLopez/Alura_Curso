package br.com.loja.persistence;

import javax.persistence.EntityManager;

import br.com.loja.model.ItemPedido;

public class ItemPedidoDAO {

	private EntityManager em;

	// Criando uma fabria de conexões
	public ItemPedidoDAO(EntityManager em) {
		this.em = em;
	}

	// Adicionando um novo objeto
	public void cadastrar(ItemPedido produto) {
		this.em.persist(produto);
	}

	// Atualizanddo objeto
	public void atualizar(ItemPedido produto) {
		em.getTransaction().begin();
		this.em.persist(produto);
		em.getTransaction().commit();

	}

	// removendo objeto
	public void remover(ItemPedido produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
	}

	// Buscando por id e retornando um objeto
	public ItemPedido buscarPorId(Long id) {
		return em.find(ItemPedido.class, id);
	}

}
