package br.com.mmartini.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mmartini.gestao.model.PrecoProduto;
import br.com.mmartini.gestao.repository.PrecoProdutoRepository;

@Controller
@RequestMapping("/cadastro/preco_produto")
public class PrecoProdutoController {

	@Autowired
	private PrecoProdutoRepository precos;

	@GetMapping("editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("cadastro/PrecoProduto");
		System.out.println("Preco do produto" + precos.findOne(id));
		return mv.addObject(precos.findOne(id));
	}

	@PostMapping
	public String salvar(PrecoProduto preco) {
		precos.save(preco);
		System.out.println("Preco do produto" + preco);
//		return "redirect:/cadastro/preco_produto/editar/"+ preco.getIdPrecoProduto();
		return "redirect:/cadastro/produto/editar/" + preco.getProduto().getIdProduto();
	}

}
