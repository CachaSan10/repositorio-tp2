package ar.edu.unju.fi.listas;

import java.util.List;
import org.springframework.stereotype.Component;
import ar.edu.unju.fi.entity.Servicio;

@Component
public class ListaServicio {
	private List<Servicio> servicios;
	public static Long id;
	
	public ListaServicio(){}
	
	/**
	 * Creacion del getter y setter del atributo List servicios
	 *
	 */
	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	
}

