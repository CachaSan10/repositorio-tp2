/**
 * 
 */
package ar.edu.unju.fi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD

=======
>>>>>>> refs/heads/main
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.service.ICategoriaService;
import jakarta.validation.Valid;

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
		modelAndView.setViewName("nueva_categoria");
		modelAndView.addObject("categoria", categoriaService.obtenerCategoria());
		return modelAndView;
	}
	
	@PostMapping("/guardar")
	public ModelAndView agregarConsejo(@Valid @ModelAttribute("categoria") Categoria categoria, BindingResult result) {
		ModelAndView  modelAndView = new ModelAndView("gestion_categorias");
		if(result.hasErrors()) {
			modelAndView.setViewName("nueva_categoria");
			modelAndView.addObject("categoria", categoria);
			return modelAndView;
		}
		
		categoriaService.guardarCategoria(categoria);
		modelAndView.addObject("categorias",categoriaService.obtenerCategorias());

		return modelAndView;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarConsejoPage(Model model,@PathVariable(value="id")Long id) {
		boolean edicion=true;
		model.addAttribute("categoria", categoriaService.buscarCategoria(id));
		model.addAttribute("edicion", edicion);
		
		return "nueva_categoria";
	}
	
	
	@PostMapping("/modificar/{id}")
	public String modificarConsejo(@ModelAttribute("categoria")Categoria categoriaModificado)  {
		categoriaService.modificarCategoria(categoriaModificado);
		return "redirect:/categoria/gestion";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarConsejo(@PathVariable(value="id")Long id) {
		categoriaService.eliminarCategoria(id);
		return "redirect:/categoria/gestion";
	}
	

}
