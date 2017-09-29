package br.com.mmartini.gestao.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ItemPedidoCompra implements Serializable {

	private static final long serialVersionUID = -8746227523631209877L;
	@Id
	@GeneratedValue
	private Long idItemPedidoCompra;
	@OneToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;
	private BigDecimal valotTotal;
	private int quantidade;

	public Long getIdItemPedidoCompra() {
		return idItemPedidoCompra;
	}

	public void setIdItemPedidoCompra(Long idItemPedidoCompra) {
		this.idItemPedidoCompra = idItemPedidoCompra;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getValotTotal() {
		return valotTotal;
	}

	public void setValotTotal(BigDecimal valotTotal) {
		this.valotTotal = valotTotal;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
