package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.listas.ListaServicio;
import ar.edu.unju.fi.service.IServicioService;

@Service("servicioServiceImp")
public class ServicioServiceImp implements IServicioService{
	
	@Autowired
	private ListaServicio servicios;
	@Autowired
	private Servicio servicio;
	
	@Override
	public List<Servicio> obtenerServicios(){
		return servicios.getServicios();
	}
	
	/**
	 * Metodo que guarda servicio a la lista de servicio
	 * 
	 */
	@Override
	public void guardarServicio(Servicio servicio){
	    ListaServicio.id++;
		servicio.setId(ListaServicio.id);
		obtenerServicios().add(servicio);
	}
	
	/**
	 * Metodo que modifica un servicio de la lista servicio
	*/ 
	@Override
	public void modificarServicio(Servicio servicioModificado){
	
		 for(Servicio servicio: obtenerServicios()) {
			 	
		    	if(servicio.getId()==servicioModificado.getId()) {
		    		servicio.setInicioHorario(servicioModificado.getInicioHorario());
		    		servicio.setFinHorario(servicioModificado.getFinHorario());
		    		servicio.setFinHorario(servicioModificado.getFinHorario());
		    		servicio.setDia(servicioModificado.getDia());
		    			    		
		    		break;
		    	}
		    }
		
	}
	
	/**
	 * Metodo que busca el servicio buscado mediante su id.
	 * @return retorna el servicio que se encontro en la lista.
	 */
	public Servicio buscarServicio(Long id) {
	    Servicio servicioEncontrado = new Servicio();
	    
	    for(Servicio servicio: obtenerServicios()) {
	    	if(servicio.getId()==id) {
	    		servicioEncontrado=servicio;
	    		break;
	    	}
	    }
		return servicioEncontrado;
	}
	
	/**
	 * Metodo que elimina el servicio dependiendo del id
	 * id representa el id del servicio que se quiere eliminar
	 */
	public void eliminarServicio(Long id) {
		for(Servicio servicio: obtenerServicios()) {
	    	if(servicio.getId()==id) {
	    		obtenerServicios().remove(servicio);
	    		break;
	    	}
	    }
	}
	@Override
	public Servicio obtenerServicio() {
		return servicio;
	}

	@Override
	public List<Servicio> obtenerServiciosSegunDia(String dia) {
		// TODO Auto-generated method stub
		return null;
	}
	

}