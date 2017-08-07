package br.com.mmartini.gestao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PedidoCompra implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idPedidoCompra;

	public Long getIdPedidoCompra() {
		return idPedidoCompra;
	}

	public void setIdPedidoCompra(Long idPedidoCompra) {
		this.idPedidoCompra = idPedidoCompra;
	}

}
