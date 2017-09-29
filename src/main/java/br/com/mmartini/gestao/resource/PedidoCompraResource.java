package br.com.mmartini.gestao.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mmartini.gestao.model.PedidoCompra;
import br.com.mmartini.gestao.repository.PedidoCompraRepository;

@RestController
@RequestMapping("/compras/pedido_compra")
@CrossOrigin("${origem-permitida}")
public class PedidoCompraResource {
	
	@Autowired
	private PedidoCompraRepository pedidos;
	
	
	@GetMapping
	public List<PedidoCompra> listar() {
		return pedidos.findAll();
	}
	
	@GetMapping("/{id}")
	public PedidoCompra abrir(@PathVariable("id") Long id) {
		return pedidos.findOne(id);
	}
	
	@PostMapping
	public PedidoCompra salvar(@RequestBody @Valid PedidoCompra pedido) {
		return pedidos.save(pedido);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable("id") Long id) {
		pedidos.delete(id);
	}

}
