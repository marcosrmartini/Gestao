package br.com.mmartini.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mmartini.gestao.model.Convidado;
import br.com.mmartini.gestao.model.Fabricante;
import br.com.mmartini.gestao.repository.FabricanteRepository;

@Controller
@RequestMapping("/cadastro/fabricante")
public class FabricantesController {

	@Autowired
	private FabricanteRepository fabricantes;
	
	@GetMapping
	public ModelAndView listar(){
		ModelAndView mv = new ModelAndView("cadastro/Fabricante");
		mv.addObject("fabricantes", fabricantes.findAll());
		mv.addObject(new Fabricante());
		return mv;
	}
	
	@PostMapping
	public String salvar(Fabricante fabricante){
		fabricantes.save(fabricante);
		return "redirect:/cadastro/fabricante";
	}
	
}
