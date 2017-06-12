package br.com.mmartini.gestao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class MenuController {

	@GetMapping
	public ModelAndView inicio(){
		ModelAndView mv = new ModelAndView("Menu");
		return mv;
	}
	
}
