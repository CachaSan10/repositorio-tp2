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
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.service.ICategoriaService;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	@Qualifier("productoServiceMysqlImp")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("categoriaServiceMysqlImp")
	private ICategoriaService categoriaService;
	
	@GetMapping("/listado")
	public String getListaProductoPage(Model model) {
		model.addAttribute("productos",productoService.obtenerListaProducto());
		return "productos";
	}
	
	@GetMapping("/nuevo")	
	public String getNuevoProductoPage(Model model) {
		boolean edicion=false;
		
		model.addAttribute("producto", productoService.obtenerProducto());
		model.addAttribute("categorias", categoriaService.obtenerCategorias());
		model.addAttribute("edicion", edicion);
		return "nuevo-producto";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarProductoPage(@Valid @ModelAttribute("producto") Producto producto, BindingResult result) {
		ModelAndView  modelAndView = new ModelAndView("gestion_productos");
		if(result.hasErrors()) {
			modelAndView.setViewName("nuevo-producto");
			modelAndView.addObject("categorias", categoriaService.obtenerCategorias());
			modelAndView.addObject("producto", productoService.obtenerProducto());
			return modelAndView;
		}
		productoService.guardarProducto(producto);
		modelAndView.addObject("productos",productoService.obtenerListaProducto());
		return modelAndView;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarProductoPage(Model model, @PathVariable(value="id") Long id){
		boolean edicion=true;
		model.addAttribute("producto", productoService.buscarProducto(id));
		model.addAttribute("edicion", edicion);
		
		return "nuevo-producto";
	}
	
	@PostMapping("/modificar/{id}")
	public String modificarProducto(@ModelAttribute("producto") Producto productoModificado) {
		productoService.modificarProducto(productoModificado);
		return "redirect:/producto/gestion";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable(value="id")Long id) {
		productoService.eliminarProducto(id);
		return "redirect:/producto/gestion";
	}
	
	@GetMapping("/gestion")
	public String getGestionConsejoPage(Model model) {
		model.addAttribute("productos", productoService.obtenerListaProducto());
		return "gestion_productos";
	}
	
}
