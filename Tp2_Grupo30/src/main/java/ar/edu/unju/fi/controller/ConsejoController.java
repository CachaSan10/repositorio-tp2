package ar.edu.unju.fi.controller;
import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import ar.edu.unju.fi.util.UploadFile;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/consejo")
public class ConsejoController {

	@Autowired
	@Qualifier("consejoServiceMysqlImp")
	private IConsejoService consejoService;
	
	
	@Autowired
	private UploadFile uploadFile;

	@GetMapping("/listado")
	public String getListaConsejo(Model model) {
		model.addAttribute("consejos", consejoService.getConsejos());
		return "consejos";
	}
	
	@GetMapping("/nuevo")
	public String getAgregarConsejoPage(Model model) {
		boolean edicion=false;
		model.addAttribute("consejo", consejoService.getConsejo());
		model.addAttribute("edicion", edicion);
		return "nuevo_consejo";
	}
	
	@PostMapping("/guardar")
	public ModelAndView agregarConsejo(@Valid @ModelAttribute("consejo") Consejo consejo, BindingResult result,
			@RequestParam("file") MultipartFile imagen ) throws IOException {
		ModelAndView  modelAndView = new ModelAndView("gestion_consejos");
		if(result.hasErrors()) {
			modelAndView.setViewName("nuevo_consejo");
			modelAndView.addObject("consejo", consejo);
			return modelAndView;
		}
		
		consejoService.addConsejo(consejo,imagen);
		modelAndView.addObject("consejos",consejoService.getConsejos() );

		return modelAndView;
	}
	
	@GetMapping("/cargar/{imagen}")
	 public ResponseEntity<Resource> goImage(@PathVariable String imagen){
		Resource resource = null;
		try {
			resource = uploadFile.load(imagen);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; imagen=\""+resource.getFilename()+"\"")
				.body(resource);
		
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarConsejoPage(Model model,@PathVariable(value="id")Long id) {
		boolean edicion=true;
		model.addAttribute("consejo", consejoService.getConsejoEncontrado(id));
		model.addAttribute("edicion", edicion);
		
		return "nuevo_consejo";
	}
	
	
	@PostMapping("/modificar/{id}")
	public String modificarConsejo(@ModelAttribute("consejo")Consejo consejoModificado,
			@RequestParam("file") MultipartFile imagen) throws IOException  {
		consejoService.updateConsejo(consejoModificado,imagen);
		return "redirect:/consejo/gestion";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarConsejo(@PathVariable(value="id")Long id) {
		consejoService.deleteConsejo(id);
		return "redirect:/consejo/gestion";
	}
	
	
	@GetMapping("/gestion")
	public String getGestionConsejoPage(Model model) {
		model.addAttribute("consejos", consejoService.getConsejos());
		return "gestion_consejos";
	}
	
	
	

}
