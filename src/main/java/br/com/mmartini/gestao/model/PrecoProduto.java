package br.com.mmartini.gestao.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PrecoProduto {

	@Id
	@GeneratedValue
	private Long idPrecoProduto;
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private TabelaPreco tabela;
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
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

	@Override
	public String toString() {
		return "PrecoProduto [idPrecoProduto=" + idPrecoProduto + ", tabela="
				+ tabela + ", produto=" + produto + ", margemLucro="
				+ margemLucro + ", preco=" + preco + "]";
	}

	
	
}
