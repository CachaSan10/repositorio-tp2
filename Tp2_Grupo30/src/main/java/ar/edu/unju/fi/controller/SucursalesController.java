package ar.edu.unju.fi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/sucursal")
public class SucursalesController {
	ListaSucursal listaSucursales = new ListaSucursal();
	
	@GetMapping("/listado")
	public String getSucursalesPage(Model model) {
		model.addAttribute("sucursales", listaSucursales.getSucursales());
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
	public ModelAndView getGuardarSucursalPage(@ModelAttribute("sucursal")Sucursal sucursal) {
		ModelAndView mav = new ModelAndView("sucursales");
		//listaSucursales.getSucursales().add(sucursal);
		listaSucursales.addSucursal(sucursal);
		mav.addObject("sucursales", listaSucursales.getSucursales());
		return mav;
	}
	@GetMapping("/modificar/{codigo}")
	public String getModificarSucursalPage(Model model,@PathVariable(value="codigo")int codigo) {
		boolean edicion=true;
		Sucursal sucursalEncontrada = new Sucursal();
		for(Sucursal sucursales: listaSucursales.getSucursales()) {
			if(sucursales.getCodigo()==codigo) {
				sucursalEncontrada = sucursales;
				break;
			}
		}
		
		model.addAttribute("sucursal", sucursalEncontrada);
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	@PostMapping("/modificar/{codigo}")
	public String modificarSucursal(@ModelAttribute("sucursal")Sucursal sucursalModificado) {
		for(Sucursal sucursal: listaSucursales.getSucursales()) {
			if(sucursal.getCodigo()==sucursalModificado.getCodigo()) {
				sucursal.setNombre(sucursalModificado.getNombre());
				sucursal.setEmail(sucursalModificado.getEmail());
				sucursal.setDireccion(sucursalModificado.getDireccion());
				sucursal.setFechaInicio(sucursalModificado.getFechaInicio());
				sucursal.setProvincia(sucursalModificado.getProvincia());
				sucursal.setTelefono(sucursalModificado.getTelefono());
				
			}
		}
		return "redirect:/sucursal/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarSucursal(@PathVariable(value="codigo")int codigo) {
		for(Sucursal sucursales: listaSucursales.getSucursales()) {
			if(sucursales.getCodigo()==codigo) {
				listaSucursales.getSucursales().remove(sucursales);
				break;
			}
		}
		
		return "redirect:/sucursal/listado";
	}
	
}
