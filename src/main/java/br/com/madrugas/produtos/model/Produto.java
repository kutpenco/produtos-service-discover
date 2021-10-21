package br.com.madrugas.produtos.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Produto implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Timestamp dataCadastro;
	private String nome;
	private Double valor;
	private Integer quantidade, produtoTipoId, produtoCategoriaId;
	private String obs;
	private Boolean	habilitado;
	
	public Produto(Integer id, String nome, Double valor, Integer quantidade, Integer produtoTipoId,
			Integer produtoCategoriaId, String obs) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
		this.produtoTipoId = produtoTipoId;
		this.produtoCategoriaId = produtoCategoriaId;
		this.obs = obs;
	}
	
	public Produto() {}

	public Integer getId() {
		return id;
	}

	public Timestamp getDataCadastro() {
		return dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public Double getValor() {
		return valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Integer getProdutoTipoId() {
		return produtoTipoId;
	}

	public Integer getProdutoCategoriaId() {
		return produtoCategoriaId;
	}

	public String getObs() {
		return obs;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}
}
