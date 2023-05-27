package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;


import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;

@Controller
@RequestMapping("/consejo")
public class ConsejoController {

	@Autowired
	private ListaConsejo listaConsejo;
	
	@Autowired
	private Consejo consejo;

	@GetMapping("/listado")
	public String getListaConsejo(Model model) {
		model.addAttribute("consejos", listaConsejo.getConsejos());
		return "consejos";
	}
	
	@GetMapping("/nuevo")
	public String getAgregarConsejoPage(Model model) {
		boolean edicion=false;
		model.addAttribute("consejo", consejo);
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo";
	}
	
	@PostMapping("/guardar")
	public ModelAndView agregarConsejo(@ModelAttribute("consejo") Consejo consejo) {
		ModelAndView  modelAndView = new ModelAndView("consejos");
		listaConsejo.addConsejo(consejo);
		modelAndView.addObject("consejos",listaConsejo.getConsejos() );

		return modelAndView;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarConsejoPage(Model model,@PathVariable(value="id")int id) {
		boolean edicion=true;
		model.addAttribute("consejo", listaConsejo.getConsejo(id));
		model.addAttribute("edicion", edicion);
		
		return "nuevo_consejo";
	}
	
	
	@PostMapping("/modificar/{id}")
	public String modificarConsejo(@ModelAttribute("consejo")Consejo consejoModificado) {
		listaConsejo.updateConsejo(consejoModificado);
		return "redirect:/consejo/listado";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarConsejo(@PathVariable(value="id")int id) {
		listaConsejo.deleteConsejo(id);
		return "redirect:/consejo/listado";
	}
	
	
	
	

}
