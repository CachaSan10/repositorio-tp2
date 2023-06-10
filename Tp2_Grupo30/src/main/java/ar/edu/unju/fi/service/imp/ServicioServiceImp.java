package ar.edu.unju.fi.service.imp;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.model.Servicio;
import ar.edu.unju.fi.service.IServicioService;

@Service
public class ServicioServiceImp implements IServicioService{
	
	@Autowired
	private ListaServicio servicios;
	
	@Override
	public List<Servicio> getServicios() {return servicios.getServicios();
	}
	
	/**
	 * Metodo que agrega servicio a la lista de servicio
	 * @param servicio representa el servicio que se va agregar a la 
	 * lista de servicio.
	 */
	@Override
	public void addServicio(Servicio servicio) throws IOException{
	    ListaServicio.id++;
		servicio.setId(ListaServicio.id);
		getServicios().add(servicio);
	}
	
	/**
	 * Metodo que modifica el servicio de la lista servicio
	 * @param servicioModificado representa el servicio modificado
	 * que se modifico en la lista servicio.
	 */
	@Override
	public void updateServicio(Servicio servicioModificado){
		
		 for(Servicio servicio: getServicios()) {
			 	
		    	if(servicio.getId()==servicioModificado.getId()) {
		    		servicio.setStartTime(servicioModificado.getStartTime());
		    		servicio.setFinishTime(servicioModificado.getFinishTime());
		    		servicio.setFirstName(servicioModificado.getFirstName());
		    		servicio.setLastName(servicioModificado.getLastName());
		    		servicio.setDay(servicioModificado.getDay());
		    		break;
		    	}
		    }
		
	}
	
	/**
	 * Metodo que busca el servicio de a traves de su id.
	 * @param id representa el id del servicio que se esta buscando en 
	 * la lista de servicio.
	 * @return el servicio que se encontro en la lista.
	 */
	public Servicio getServicioEncontrado(int id) {
	    Servicio servicioEncontrado = new Servicio();
	    
	    for(Servicio servicio: getServicios()) {
	    	if(servicio.getId()==id) {
	    		servicioEncontrado=servicio;
	    		break;
	    	}
	    }
		return servicioEncontrado;
	}
	
	/**
	 * Metodo que elimina el servicio dependiendo del id
	 * @param id representa el id del servicio que se quiere eliminar
	 */
	public void deleteServicio(int id) {
		for(Servicio servicio: getServicios()) {
	    	if(servicio.getId()==id) {
	    		getServicios().remove(servicio);
	    		break;
	    	}
	    }
	}
}
