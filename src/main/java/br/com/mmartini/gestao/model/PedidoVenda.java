package br.com.mmartini.gestao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PedidoVenda implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idPedidoVenda;

	public Long getIdPedidoVenda() {
		return idPedidoVenda;
	}

	public void setIdPedidoVenda(Long idPedidoVenda) {
		this.idPedidoVenda = idPedidoVenda;
	}

}
