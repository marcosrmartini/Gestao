package br.com.mmartini.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mmartini.gestao.model.Cliente;
import br.com.mmartini.gestao.repository.ClienteRepository;

@Controller
@RequestMapping("/cadastro/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clientes;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("cadastro/Cliente");
		mv.addObject("Clientes", clientes.findAll());
		mv.addObject(new Cliente());
		return mv;
	}

	@GetMapping("editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("cadastro/Cliente");
		mv.addObject("clientes", clientes.findAll());
		return mv.addObject(clientes.findOne(id));
	}

	@GetMapping("deletar/{id}")
	public String delete(@PathVariable("id") Long id) {
		clientes.delete(id);
		return "redirect:/cadastro/cliente";
	}

	@PostMapping
	public String salvar(Cliente cliente) {
		clientes.save(cliente);
		return "redirect:/cadastro/cliente/editar/" + cliente.getIdCliente();
	}

}
