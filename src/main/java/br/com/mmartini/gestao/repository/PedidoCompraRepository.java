package br.com.mmartini.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mmartini.gestao.model.PedidoCompra;

public interface PedidoCompraRepository extends JpaRepository<PedidoCompra, Long>{

}
