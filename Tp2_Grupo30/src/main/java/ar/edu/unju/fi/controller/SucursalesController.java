package ar.edu.unju.fi.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.service.IProvinciaService;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/sucursal")
public class SucursalesController {
	@Autowired
	@Qualifier("sucursalServiceMysql")
	private ISucursalService sucursalService;
	
	@Autowired
	private IProvinciaService provinciaService;
	

	@PostMapping("/limpiar")
	public String limpiar(Model model) {
		
	    List<Sucursal> sucursales = sucursalService.getLista();
	    model.addAttribute("sucursales", sucursales);
	    return "sucursales";
	}

	@PostMapping("/buscar")
	public String buscarPorFecha(@RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaInicio, @RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaFin, Model model) {
		List<Sucursal> sucursales = sucursalService.buscarPorRangoFecha(fechaInicio, fechaFin);
		model.addAttribute("sucursales", sucursales);
		return "sucursales";
}

	@GetMapping("/gestion")
	public String getGestionPage(Model model) {
		model.addAttribute("sucursales", sucursalService.getLista());
		return "gestion_sucursales";
	}

	
	//Listado de sucursales
	@GetMapping("/listado")
	public String getSucursalesPage(Model model) {		
		model.addAttribute("sucursales", sucursalService.getLista());
		return "sucursales";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		boolean edicion= false;
		model.addAttribute("provincias", provinciaService.getLista());
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
			mav.addObject("provincias", provinciaService.getLista());
			return mav;
		}
		mav.addObject("provincia", provinciaService.getLista());
		sucursalService.guardarSucursal(sucursal);
		mav.setViewName("redirect:/sucursal/listado");
		return mav;
	}
	//Peticion de modificar sucursal
	@GetMapping("/modificar/{id}")
	public String getModificarSucursalPage(Model model,@PathVariable(value="id")Long id) {
		boolean edicion=true;
		Sucursal sucursalEncontrada = sucursalService.buscarSucursal(id);
		
		model.addAttribute("provincias", provinciaService.getLista());
		model.addAttribute("sucursal", sucursalEncontrada);
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	
	@PostMapping("/modificar/{id}")
	public String modificarSucursal(@Valid @ModelAttribute("sucursal")Sucursal sucursalModificado, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "nueva_sucursal";
		}
		sucursalService.modificarSucursal(sucursalModificado);
		return "redirect:/sucursal/gestion";
	}
	//Peticion de eliminar sucursal
	@GetMapping("/eliminar/{id}")
	public String eliminarSucursal(@PathVariable(value="id")Long id) {
		
		Sucursal sucursalEncontradaSucursal = sucursalService.buscarSucursal(id);
		sucursalService.eliminarSucursal(sucursalEncontradaSucursal);
		
		return "redirect:/sucursal/gestion";
	}
	
}
