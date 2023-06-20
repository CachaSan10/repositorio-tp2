/**
 * 
 */
package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.service.ICategoriaService;

/**
 * @author Nahuel Alberto Cachambi
 *
 */

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	@Qualifier("categoriaServiceMysqlImp")
	private ICategoriaService categoriaService;
	
	
	@GetMapping("/gestion")
	public String getCategoriaGestionPage(Model model) {
		model.addAttribute("categorias", categoriaService.obtenerCategorias());
		return "gestion_categorias";
	}
	
	@GetMapping("/nuevo")
	public ModelAndView getNuevoCategoriaPage(ModelAndView modelAndView) {
		modelAndView.setViewName("gestion_categorias");
		modelAndView.addObject("categoria", categoriaService.obtenerCategoria());
		return modelAndView;
	}
	
	

}
