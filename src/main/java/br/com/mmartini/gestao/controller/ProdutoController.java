package br.com.mmartini.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mmartini.gestao.model.Fornecedor;
import br.com.mmartini.gestao.model.Produto;
import br.com.mmartini.gestao.repository.FabricanteRepository;
import br.com.mmartini.gestao.repository.FornecedorRepository;
import br.com.mmartini.gestao.repository.ProdutoRepository;

@Controller
@RequestMapping("/cadastro/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtos;
	@Autowired
	private FornecedorRepository fornecedores;
	@Autowired
	private FabricanteRepository fabricantes;
	
	
	@GetMapping
	private ModelAndView listar(){
		ModelAndView mv = new ModelAndView("/cadastro/Produto");
		mv.addObject("fabricantes", fabricantes.findAll());
		mv.addObject(new Produto());
		return mv;
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("cadastro/Produto");
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
		return "redirect:/cadastro/produto";
	}


}
