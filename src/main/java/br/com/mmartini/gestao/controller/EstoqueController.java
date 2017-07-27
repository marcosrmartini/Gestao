package br.com.mmartini.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mmartini.gestao.model.Estoque;
import br.com.mmartini.gestao.repository.EstoqueRepository;

@Controller
@RequestMapping("/cadastro/estoque")
public class EstoqueController {

	@Autowired
	private EstoqueRepository estoques;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("cadastro/Estoque");
		mv.addObject("estoques", estoques.findAll());
		mv.addObject(new Estoque());
		return mv;
	}

	@GetMapping("editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("cadastro/Estoque");
		mv.addObject("estoques", estoques.findAll());
		return mv.addObject(estoques.findOne(id));
	}

	@GetMapping("deletar/{id}")
	public String delete(@PathVariable("id") Long id) {
		estoques.delete(id);
		return "redirect:/cadastro/estoque";
	}

	@PostMapping
	public String salvar(Estoque estoque) {
		estoques.save(estoque);
		return "redirect:/cadastro/estoque/editar/" + estoque.getIdEstoque();
	}

}
