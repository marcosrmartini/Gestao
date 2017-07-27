package br.com.mmartini.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mmartini.gestao.model.Produto;
import br.com.mmartini.gestao.repository.FabricanteRepository;
import br.com.mmartini.gestao.repository.FornecedorRepository;
import br.com.mmartini.gestao.repository.GrupoRepository;
import br.com.mmartini.gestao.repository.PrecoProdutoRepository;
import br.com.mmartini.gestao.repository.ProdutoRepository;
import br.com.mmartini.gestao.repository.TabelaPrecoRepository;

@Controller
@RequestMapping("/cadastro/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtos;
	@Autowired
	private FornecedorRepository fornecedores;
	@Autowired
	private FabricanteRepository fabricantes;
	@Autowired
	private GrupoRepository grupos;
    @Autowired
    private PrecoProdutoRepository precos;
    @Autowired
    private TabelaPrecoRepository tabelas;
	
	@GetMapping
	private ModelAndView listar(){
		ModelAndView mv = new ModelAndView("/cadastro/Produto");
		mv.addObject("produtos", produtos.findAll());
		mv.addObject("fabricantes", fabricantes.findAll());
		mv.addObject("fornecedores", fornecedores.findAll());
		mv.addObject("grupos", grupos.findAll());
		mv.addObject("tabelasPreco", tabelas.findAll());
		mv.addObject(new Produto());
		return mv;
	}
	
	@GetMapping("abrirPesquisa")
	private ModelAndView abrirPesquisaProduto(){
		ModelAndView mv = new ModelAndView("/cadastro/PesquisaProduto");
		mv.addObject(new Produto());
		return mv;
	}

	@PostMapping("pesquisaProduto")
	private ModelAndView pesquisaProduto(@ModelAttribute("produto") Produto produto){
		ModelAndView mv = new ModelAndView("/cadastro/PesquisaProduto");
		mv.addObject("produtos", produtos.pesquisaPorDescricao("%" + produto.getDescricao().toUpperCase() + "%"));
		return mv;
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("cadastro/Produto");
		mv.addObject("fabricantes", fabricantes.findAll());
		mv.addObject("fornecedores", fornecedores.findAll());
		mv.addObject("precosProduto", precos.selecionarProduto(id));
		mv.addObject("grupos", grupos.findAll());		
		mv.addObject("tabelasPreco", tabelas.findAll());		
		return mv.addObject(produtos.findOne(id));
	}

	@GetMapping("deletar/{id}")
	public String delete(@PathVariable("id") Long id) {
		precos.deletarProduto(id);
		produtos.delete(id);
		System.out.println("Deletando produto " + id);
		return "redirect:/cadastro/produto";
	}

	
	@PostMapping
	private String salvar(Produto p){
		produtos.save(p);
		precos.inserirPrecos();
		return "redirect:/cadastro/produto/editar/" + p.getIdProduto();
	}


}
