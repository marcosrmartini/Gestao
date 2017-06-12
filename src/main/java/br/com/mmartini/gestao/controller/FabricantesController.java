package br.com.mmartini.gestao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cadastro/fabricante")
public class FabricantesController {

	@GetMapping
	public ModelAndView listar(){
		ModelAndView mv = new ModelAndView("cadastro/Fabricante");
		return mv;
	}
	
}
