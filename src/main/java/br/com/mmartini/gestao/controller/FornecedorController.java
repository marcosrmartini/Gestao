package br.com.mmartini.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mmartini.gestao.model.Fornecedor;
import br.com.mmartini.gestao.repository.FornecedorRepository;

@Controller
@RequestMapping("/cadastro/fornecedor")
public class FornecedorController {
	
	@Autowired
	private FornecedorRepository fornecedores;
	
	@GetMapping
	private ModelAndView listar(){
		ModelAndView mv = new ModelAndView("/cadastro/Fornecedor");
		mv.addObject("fornecedores", fornecedores.findAll());
		mv.addObject(new Fornecedor());
		return mv;
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("cadastro/Fornecedor");
		mv.addObject("fornecedores", fornecedores.findAll());		
		return mv.addObject(fornecedores.findOne(id));
	}

	@GetMapping("deletar/{id}")
	public String delete(@PathVariable("id") Long id) {
		fornecedores.delete(id);
		return "redirect:/cadastro/fornecedor";
	}

	
	@PostMapping
	private String salvar(Fornecedor f){
		fornecedores.save(f);
		return "redirect:/cadastro/fornecedor";
	}

}
