package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class NavController {
	
	@GetMapping("/{page}")
	public ModelAndView getPageWithParam(@PathVariable(value = "page") String page) {
		ModelAndView modelAndView = new ModelAndView(page);
		return modelAndView;
	}
}
