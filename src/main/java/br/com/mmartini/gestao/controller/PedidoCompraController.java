package br.com.mmartini.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mmartini.gestao.model.PedidoCompra;
import br.com.mmartini.gestao.repository.PedidoCompraRepository;


@Controller
@RequestMapping("/compras/pedido_compra")
public class PedidoCompraController {
	
	@Autowired
	private PedidoCompraRepository pedidos;
	
	@GetMapping("/abrir")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("compras/PedidoCompra");
//		mv.addObject("pedido", new PedidoCompra());
		return mv;
	}

//	@GetMapping("editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		PedidoCompra pedido = pedidos.findOne(id);
		ModelAndView mv = new ModelAndView("compras/PedidoCompra");
		mv.addObject("pedido", pedido);		
		mv.addObject("itemsPedido", pedido.getItens());
		return mv;
	}

//	@GetMapping("deletar/{id}")
	public String delete(@PathVariable("id") Long id) {
		pedidos.delete(id);
		return "redirect:/compras/pedido_compra";
	}

//	@PostMapping
	public String salvar(PedidoCompra pedido) {
		pedidos.save(pedido);
		return "redirect:/compras/pedido_compra/editar/" + pedido.getIdPedidoCompra();
	}


}
