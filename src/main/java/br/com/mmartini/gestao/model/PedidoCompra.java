package br.com.mmartini.gestao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PedidoCompra implements Serializable {

	private static final long serialVersionUID = 3461379522826239495L;
	@Id
	@GeneratedValue
	private Long idPedidoCompra;
	@OneToOne
	@JoinColumn(name = "id_fornecedor")
	private Fornecedor fornecedor;
	private Date data;

	private BigDecimal frete;
	private BigDecimal desconto;
	private BigDecimal totalProdutos;
	private BigDecimal valorTotal;
	private Boolean baixado;

	@OneToMany
	@JoinColumn(name = "id_pedido_compra")
	private List<ItemPedidoCompra> itens;

	public Long getIdPedidoCompra() {
		return idPedidoCompra;
	}

	public void setIdPedidoCompra(Long idPedidoCompra) {
		this.idPedidoCompra = idPedidoCompra;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getFrete() {
		return frete;
	}

	public void setFrete(BigDecimal frete) {
		this.frete = frete;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getTotalProdutos() {
		return totalProdutos;
	}

	public void setTotalProdutos(BigDecimal totalProdutos) {
		this.totalProdutos = totalProdutos;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Boolean getBaixado() {
		return baixado;
	}

	public void setBaixado(Boolean baixado) {
		this.baixado = baixado;
	}

	public List<ItemPedidoCompra> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedidoCompra> itens) {
		this.itens = itens;
	}

}
