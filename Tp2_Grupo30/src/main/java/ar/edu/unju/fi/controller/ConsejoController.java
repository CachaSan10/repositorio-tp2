package ar.edu.unju.fi.controller;



import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaConsejoSalud;
import ar.edu.unju.fi.model.Consejo;

@Controller
@RequestMapping("/")
public class ConsejoController {

	private ListaConsejoSalud listaConsejos = new ListaConsejoSalud();


	@GetMapping(path = "/consejo-salud")
	public ModelAndView getListaConsejo() {
		ModelAndView modelAndView = new ModelAndView("consejo-salud");
		modelAndView.addObject("listaConsejo", listaConsejos.getConsejos());
		return modelAndView;
	}
	
	@GetMapping("/agregar-consejo")
	public ModelAndView getPageAgregarConsejo() {
		ModelAndView modelAndView = new ModelAndView("agregar-consejo");
		modelAndView.addObject("consejo", new Consejo());
		return modelAndView;
	}
	
	@PostMapping(value="/agregar-consejo")
	public String addConsejo(@ModelAttribute Consejo consejo) {
		consejo.setFechaPublicacion(LocalDate.now());
		listaConsejos.getConsejos().add(consejo);
		listaConsejos.setConsejos(listaConsejos.getConsejos());
		return "redirect:/consejo-salud";
	}
	
	
	

}
