package br.com.loja.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String nome;
	
	@Column(length = 50)
	private String descricao;
	
	@Column(precision = 5,scale = 2)
	private BigDecimal preco;
	
	private LocalDate dataCadastro = LocalDate.now();
	
	@ManyToOne
	private Categoria categorias;

	public Produto(String nome, String descricao, BigDecimal preco, Categoria categorias) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categorias = categorias;
	}
	
	
}
