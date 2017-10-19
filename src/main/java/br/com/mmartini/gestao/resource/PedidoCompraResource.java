package br.com.mmartini.gestao.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<List<PedidoCompra>> listar() {
		return new ResponseEntity<List<PedidoCompra>>(pedidos.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoCompra> abrir(@PathVariable("id") Long id) {
		return new ResponseEntity<PedidoCompra>(pedidos.findOne(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PedidoCompra> salvar(@RequestBody @Valid PedidoCompra pedido) {
		return new ResponseEntity<PedidoCompra>( pedidos.save(pedido), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<PedidoCompra> alterar(@RequestBody @Valid PedidoCompra pedido) {
		return new ResponseEntity<PedidoCompra>( pedidos.save(pedido), HttpStatus.OK);
	}

	@DeleteMapping
	public void excluir(@RequestBody @Valid PedidoCompra pedido) {
		pedidos.delete(pedido.getIdPedidoCompra());
	}

}
