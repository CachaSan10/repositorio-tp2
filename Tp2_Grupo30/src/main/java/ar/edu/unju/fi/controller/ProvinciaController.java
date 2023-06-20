package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.service.IProvinciaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/provincia")
public class ProvinciaController {
	
	@Autowired
	private IProvinciaService provinciaService;
	
	@GetMapping("/listado")
	public String getProvinciasPageString(Model model) {
		model.addAttribute("provincias", provinciaService.getLista());
		return "provincias";
	}
	
	
	@GetMapping("/nuevo")
	public String getNuevaProvinciaPage(Model model) {
		boolean edicion=false;
		model.addAttribute("provincia", new Provincia());
		model.addAttribute("edicion", edicion);
		return "nueva_provincia";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarProvinciaPage(@Valid @ModelAttribute("provincia")Provincia provincia, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView("provincias");
		
		if(bindingResult.hasErrors()) {
			mav.setViewName("nueva_provincia");
			mav.addObject("edicion", false);
			return mav;
		}
		provinciaService.guardarProvincia(provincia);
		mav.setViewName("redirect:/provincia/listado");
		return mav;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarProvinciaPage(Model model, @PathVariable(value="id")Long id) {
		boolean edicion=true;
		Provincia provinciaEncontrada = provinciaService.buscarProvincia(id);
		
		model.addAttribute("provincia",	provinciaEncontrada);
		model.addAttribute("edicion", edicion);
		return "nueva_provincia";
	}
	
	
	@PostMapping("/modificar/{id}")
	public String modificarProvincia(@Valid @ModelAttribute("provincia")Provincia provinciaModificado, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "nueva_provincia";
		}
		provinciaService.modificarProvincia(provinciaModificado);
		return "redirect:/provincia/listado";
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarProvincia(@PathVariable(value="id")Long id) {
		Provincia provinciaEncontrada = provinciaService.buscarProvincia(id);
		provinciaService.eliminarProvincia(provinciaEncontrada);
	
		return "redirect:/provincia/listado";
	}
	
	
	
}
