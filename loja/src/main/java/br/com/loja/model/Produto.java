package br.com.loja.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
<<<<<<< Updated upstream
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "produtos")
=======
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
@NamedQuery(name = "Produto.produtosPorCategoria", query = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome")
>>>>>>> Stashed changes
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
<<<<<<< Updated upstream
	
	@Column(length = 50)
	private String nome;
	
	@Column(length = 50)
	private String descricao;
	
	@Column(precision = 7,scale = 2)
	private BigDecimal preco;
	
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	@ManyToOne
	private Categoria categorias;

	public Produto(String nome, String descricao, BigDecimal preco, Categoria categorias) {
=======
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private LocalDate dataCadastro = LocalDate.now();

	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;

	public Produto() {
	}

	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
>>>>>>> Stashed changes
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}
<<<<<<< Updated upstream
	
	
=======

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

>>>>>>> Stashed changes
}
