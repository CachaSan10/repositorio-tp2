package ar.edu.unju.fi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.model.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/sucursal")
public class SucursalesController {
	@Autowired
	private ISucursalService sucursalService;
	
	
	//Listado de sucursales
	@GetMapping("/listado")
	public String getSucursalesPage(Model model) {
		model.addAttribute("sucursales", sucursalService.getLista());
		return "sucursales";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		boolean edicion= false;
		model.addAttribute("sucursal", new Sucursal());
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult bindingResult ) {
		ModelAndView mav = new ModelAndView("sucursales");
		if(bindingResult.hasErrors()) {
			mav.setViewName("nueva_sucursal");
			mav.addObject("edicion", false);
			return mav;
		}
		sucursalService.guardarSucursal(sucursal);
		mav.addObject("sucursales", sucursalService.getLista());
		return mav;
	}
	//Peticion de modificar sucursal
	@GetMapping("/modificar/{codigo}")
	public String getModificarSucursalPage(Model model,@PathVariable(value="codigo")int codigo) {
		boolean edicion=true;
		Sucursal sucursalEncontrada = sucursalService.buscarSucursal(codigo);
		
		model.addAttribute("sucursal", sucursalEncontrada);
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	@PostMapping("/modificar/{codigo}")
	public String modificarSucursal(@Valid @ModelAttribute("sucursal")Sucursal sucursalModificado, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "nueva_sucursal";
		}
		sucursalService.modificarSucursal(sucursalModificado);
		return "redirect:/sucursal/listado";
	}
	//Peticion de eliminar sucursal
	@GetMapping("/eliminar/{codigo}")
	public String eliminarSucursal(@PathVariable(value="codigo")int codigo) {
		
		Sucursal sucursalEncontradaSucursal = sucursalService.buscarSucursal(codigo);
		sucursalService.eliminarSucursal(sucursalEncontradaSucursal);
		
		return "redirect:/sucursal/listado";
	}
	
}
