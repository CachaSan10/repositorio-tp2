package ar.edu.unju.fi.service.imp;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import ar.edu.unju.fi.util.UploadFile;

public class ConsejoServiceImp implements IConsejoService {

	@Autowired
	private ListaConsejo consejos; 
	
	
	@Autowired
	private UploadFile uploadFile;
	
	/**
	 * Metodo que retorna la lista de consejos
	 * @return consejos.getConsejos()
	 */
	@Override
	public List<Consejo> getConsejos() {
		return consejos.getConsejos();
	}

	/**
	 * Metodo que agrega el consejo a la lista
	 * @param consejo representa el consejo que se va agregar a la lista
	 * @param imagen representa la imagen que es parte del consejo
	 */
	@Override
	public void addConsejo(Consejo consejo, MultipartFile imagen) throws IOException {
		ListaConsejo.id++;
		consejo.setFechaPublicacion(LocalDate.now());
		consejo.setId(ListaConsejo.id);
		String uniqueFileName = uploadFile.copy(imagen);
		consejo.setImagen(uniqueFileName);
		getConsejos().add(consejo);	
	}

	/**
	 * Metodo que retorna el consejo que se buscaba
	 * @param id representa el id del consejo que se desea encontrar en la lista
	 * @return consejoEncontrado
	 */
	@Override
	public Consejo getConsejo(int id) {
		Consejo consejoEncontrado = new Consejo();
	    for(Consejo consejo: getConsejos()) {
	    	if(consejo.getId()==id) {
	    		consejoEncontrado=consejo;
	    		break;
	    	}
	    }
		return consejoEncontrado;		
	}

	/**
	 * Metodo que modifica al consejo que esta en la lista
	 * @param consejoModificado representa el consejo que se desea modificar en la lista
	 * @param imagen representa la imagen que se modifico del consejo
	 */
	@Override
	public void updateConsejo(Consejo consejoModificado, MultipartFile imagen) throws IOException {
		 String imagenString = uploadFile.copy(imagen);
		 for(Consejo consejo: getConsejos()) {
		    	if(consejo.getId() == consejoModificado.getId()) {
		    		consejo.setFechaPublicacion(LocalDate.now());
		    		consejo.setParrafo(consejoModificado.getParrafo());
		    		consejo.setTitulo(consejoModificado.getTitulo());
		    		   uploadFile.delete(consejo.getImagen());
		    			consejo.setImagen(imagenString);
		    		break;
		    	}
		    }		
	}

	/**
	 * Metodo que elimina el consejo de la lista de consejo
	 * @param id representa el id del consejo que se desea eliminar
	 */
	@Override
	public void deleteConsejo(int id) {
		for(Consejo consejo: getConsejos()) {
	    	if(consejo.getId()==id) {
	    		uploadFile.delete(consejo.getImagen());
	    		getConsejos().remove(consejo);
	    		break;
	    	}
	    }		
	}

}
