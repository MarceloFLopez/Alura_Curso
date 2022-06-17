package br.com.loja.persistence;

import javax.persistence.EntityManager;

import br.com.loja.model.Cliente;

public class ClienteDAO {

	private EntityManager em;

	// Criando uma fabria de conexões
	public ClienteDAO(EntityManager em) {
		this.em = em;
	}
	
	// Adicionando um novo objeto
	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}
	

	
	
}
