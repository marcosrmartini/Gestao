package br.com.mmartini.gestao.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TabelaPreco implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idTabelaPreco;
	private String descricao;
	private double margemLucro;
	private BigDecimal preco;

	public Long getIdTabelaPreco() {
		return idTabelaPreco;
	}

	public void setIdTabelaPreco(Long idTabelaPreco) {
		this.idTabelaPreco = idTabelaPreco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
