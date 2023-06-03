package ar.edu.unju.fi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.model.Sucursal;
import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/sucursal")
public class SucursalesController {
	
	//Se inyecta objeto de tipo sucursal
	@Autowired
	private ListaSucursal listaSucursales ;
	@Autowired
	private Sucursal sucursal;
	
	//Listado de sucursales
	@GetMapping("/listado")
	public String getSucursalesPage(Model model) {
		model.addAttribute("sucursales", listaSucursales.getSucursales());
		return "sucursales";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		boolean edicion= false;
		model.addAttribute("sucursal", sucursal);
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult bindingResult ) {
		ModelAndView mav = new ModelAndView("sucursales");
		if(bindingResult.hasErrors()) {
			mav.setViewName("nueva_sucursal");
			mav.addObject("sucursal", sucursal);
			return mav;
		}
		//listaSucursales.getSucursales().add(sucursal);
		listaSucursales.addSucursal(sucursal);
		mav.addObject("sucursales", listaSucursales.getSucursales());
		return mav;
	}
	//Peticion de modificar sucursal
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
	//Peticion de eliminar sucursal
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
