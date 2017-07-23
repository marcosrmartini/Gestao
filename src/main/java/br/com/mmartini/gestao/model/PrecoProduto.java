package br.com.mmartini.gestao.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PrecoProduto {

	@Id
	@GeneratedValue
	private Long idPrecoProduto;
	@OneToOne
	private TabelaPreco tabela;
	@OneToOne
	private Produto produto;
	private double margemLucro;
	private BigDecimal preco;

	public Long getIdPrecoProduto() {
		return idPrecoProduto;
	}

	public void setIdPrecoProduto(Long idPrecoProduto) {
		this.idPrecoProduto = idPrecoProduto;
	}

	public TabelaPreco getTabela() {
		return tabela;
	}

	public void setTabela(TabelaPreco tabela) {
		this.tabela = tabela;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(double margemLucro) {
		this.margemLucro = margemLucro;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
