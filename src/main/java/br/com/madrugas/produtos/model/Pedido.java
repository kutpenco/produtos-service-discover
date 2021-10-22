package br.com.madrugas.produtos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "data_criacao", nullable = false)
	private LocalDate dataCriacao = LocalDate.now();

	private BigDecimal valorTotal = BigDecimal.ZERO;
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<>();


	public Pedido() {
	}

	public Integer getId() {
		return id;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void adicionaItem(ItemPedido item) {
		this.valorTotal = this.valorTotal.add(item.getValorTotal());
		item.setPedido(this);
		this.itens.add(item);
	}

	public List<ItemPedido> getItens() {
		return itens;
	}
}
