package br.com.mmartini.gestao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class HistoricoEstoqueProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idHistoricoEstoqueProduto;
	@OneToOne
	private Produto produto;
	@OneToOne
	private Estoque estoque;
	@OneToOne
	private PedidoCompra pedidoCompra;
	@OneToOne
	private PedidoVenda pedidoVenda;
	private String historico;
	private BigDecimal quantidade;
	private BigDecimal totalEstoque;
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	transient Long idEstoque;

	public Long getIdHistoricoEstoqueProduto() {
		return idHistoricoEstoqueProduto;
	}

	public void setIdHistoricoEstoqueProduto(Long idHistoricoEstoqueProduto) {
		this.idHistoricoEstoqueProduto = idHistoricoEstoqueProduto;
	}

	public PedidoCompra getPedidoCompra() {
		return pedidoCompra;
	}

	public void setPedidoCompra(PedidoCompra pedidoCompra) {
		this.pedidoCompra = pedidoCompra;
	}

	public PedidoVenda getPedidoVenda() {
		return pedidoVenda;
	}

	public void setPedidoVenda(PedidoVenda pedidoVenda) {
		this.pedidoVenda = pedidoVenda;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getTotalEstoque() {
		return totalEstoque;
	}

	public void setTotalEstoque(BigDecimal totalEstoque) {
		this.totalEstoque = totalEstoque;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getIdEstoque() {
		//return idEstoque;
		Long retorno = new Long(0);
		if (this.estoque != null){
			retorno = this.estoque.getIdEstoque();
		}
		return retorno;
	}

	public void setIdEstoque(Long idEstoque) {
		this.idEstoque = idEstoque;
	}

	
	
}
