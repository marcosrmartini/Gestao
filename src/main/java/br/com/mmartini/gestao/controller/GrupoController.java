package br.com.mmartini.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mmartini.gestao.model.Grupo;
import br.com.mmartini.gestao.repository.GrupoRepository;

@Controller
@RequestMapping("/cadastro/grupo")
public class GrupoController {

	@Autowired
	private GrupoRepository grupos;
	
	@GetMapping
	private ModelAndView listar(){
		ModelAndView mv = new ModelAndView("/cadastro/Grupo");
		mv.addObject("grupos", grupos.findAll());
		mv.addObject(new Grupo());
		return mv;
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("cadastro/Grupo");
		mv.addObject("grupos", grupos.findAll());		
		return mv.addObject(grupos.findOne(id));
	}

	@GetMapping("deletar/{id}")
	public String delete(@PathVariable("id") Long id) {
		grupos.delete(id);
		return "redirect:/cadastro/grupo";
	}

	
	@PostMapping
	private String salvar(Grupo g){
		grupos.save(g);
		return "redirect:/cadastro/grupo";
	}

}
