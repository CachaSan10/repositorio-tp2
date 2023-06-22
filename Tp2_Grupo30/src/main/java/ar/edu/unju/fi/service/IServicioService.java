package ar.edu.unju.fi.service;

import java.util.List;
import ar.edu.unju.fi.entity.Servicio;

public interface IServicioService {
	
	public List<Servicio> obtenerServicios();
	
	public void agregarServicio(Servicio servicio);
	
	public Servicio obtenerServicioEncontrado(Long id);
	
	public void actualizarServicio(Servicio servicioModificado);
	
	public void eliminarServicio(Servicio servicio);

	public Servicio obtenerServicio();
	
	public List<Servicio> obtenerServiciosSegunDia(String dia);
}