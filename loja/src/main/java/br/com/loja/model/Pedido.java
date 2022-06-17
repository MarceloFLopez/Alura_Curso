package br.com.loja.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime dataCadastro = LocalDateTime.now();

	private BigDecimal vavlor_toal;

	@ManyToOne
	private Cliente cliente;

	public Pedido(Cliente clientes) {
		this.cliente = clientes;
	}

	public Pedido(Long id, LocalDateTime dataCadastro, BigDecimal vavlor_toal, Cliente cliente) {
		super();
		this.id = id;
		this.dataCadastro = dataCadastro;
		this.vavlor_toal = vavlor_toal;
		this.cliente = cliente;
	}

	public Pedido() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public BigDecimal getVavlor_toal() {
		return vavlor_toal;
	}

	public void setVavlor_toal(BigDecimal vavlor_toal) {
		this.vavlor_toal = vavlor_toal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", dataCadastro=" + dataCadastro + ", vavlor_toal=" + vavlor_toal + ", cliente="
				+ cliente + "]";
	}

}
