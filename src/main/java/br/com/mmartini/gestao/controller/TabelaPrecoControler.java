package br.com.mmartini.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mmartini.gestao.model.Grupo;
import br.com.mmartini.gestao.model.TabelaPreco;
import br.com.mmartini.gestao.repository.PrecoProdutoRepository;
import br.com.mmartini.gestao.repository.TabelaPrecoRepository;

@Controller
@RequestMapping("/cadastro/tabela_preco")
public class TabelaPrecoControler {
	
	@Autowired
	private TabelaPrecoRepository tabelas;
	
	@Autowired
	private PrecoProdutoRepository precos;
	
	@GetMapping
	private ModelAndView listar(){
		ModelAndView mv = new ModelAndView("/cadastro/TabelaPreco");
		mv.addObject("tabelas", tabelas.findAll());
		mv.addObject(new TabelaPreco());
		return mv;
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("cadastro/TabelaPreco");
		mv.addObject("tabelas", tabelas.findAll());		
		return mv.addObject(tabelas.findOne(id));
	}

	@GetMapping("deletar/{id}")
	public String delete(@PathVariable("id") Long id) {
		precos.deletarTabelaPreco(id);
		tabelas.delete(id);
		return "redirect:/cadastro/tabela_preco";
	}

	
	@PostMapping
	private String salvar(TabelaPreco t){
		tabelas.save(t);
		precos.inserirPrecos();
		return "redirect:/cadastro/tabela_preco";
	}
	

}
