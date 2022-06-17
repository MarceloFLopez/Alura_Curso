package br.com.loja.testConnection;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.loja.model.Categoria;
import br.com.loja.model.Cliente;
import br.com.loja.model.ItemPedido;
import br.com.loja.model.Pedido;
import br.com.loja.model.Produto;
import br.com.loja.persistence.CategoriaDAO;
import br.com.loja.persistence.ClienteDAO;
import br.com.loja.persistence.ItemPedidoDAO;
import br.com.loja.persistence.PedidoDAO;
import br.com.loja.persistence.ProdutoDAO;
import br.com.loja.util.JPAUtil;

public class CadastroDePedido {

	public static void main(String[] args) {
		cadatrarProdutos();
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		Produto produto = produtoDAO.buscarPorId(1l);
		
		Cliente cliente = new Cliente(null, "Marcelo", "123456");
		ClienteDAO clienteDAO = new ClienteDAO(em);
		clienteDAO.cadastrar(cliente);
		
		Pedido pedido = new Pedido(cliente);
		PedidoDAO pedidoDAO = new PedidoDAO(em);
		pedidoDAO.cadastrar(pedido);
		
		ItemPedido itemPedido =new ItemPedido(10,pedido,produto);
		ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO(em);
		
		pedido.adicionarItem(itemPedido);
		itemPedidoDAO.cadastrar(itemPedido);		
		
		ItemPedido i = itemPedidoDAO.buscarPorId(1l);
		System.out.println(i);
		
		em.getTransaction().commit();
		
		
		

	}

	public static void cadatrarProdutos() {
		Categoria a = new Categoria(null, "Celulares");
		Categoria a1 = new Categoria(null, "Eletrodomésticos");

		Produto produto = new Produto("Xiaomi Redmi", "Celular TOP", new BigDecimal(800.00), a);
		Produto produto1 = new Produto("Samsumg Galaxy", "Celular TOP", new BigDecimal(1800.00), a);

		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		produtoDAO.cadastrar(produto);
		produtoDAO.cadastrar(produto1);
		categoriaDAO.cadastrar(a);
		categoriaDAO.cadastrar(a1);
		em.getTransaction().commit();
	}
}
