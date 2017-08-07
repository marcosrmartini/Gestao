package br.com.mmartini.gestao.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EstoqueProduto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idEstoqueProduto;
	@OneToOne
	private Estoque estoque;
	@OneToOne
	private Produto produto;
	private BigDecimal estoqueMinimo;
	private BigDecimal estoqueMaximo;
	private BigDecimal quantidade;

	public Long getIdEstoqueProduto() {
		return idEstoqueProduto;
	}

	public void setIdEstoqueProduto(Long idEstoqueProduto) {
		this.idEstoqueProduto = idEstoqueProduto;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getEstoqueMinino() {
		return estoqueMinimo;
	}

	public void setEstoqueMinino(BigDecimal estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public BigDecimal getEstoqueMaximo() {
		return estoqueMaximo;
	}

	public void setEstoqueMaximo(BigDecimal estoqueMaximo) {
		this.estoqueMaximo = estoqueMaximo;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

}
