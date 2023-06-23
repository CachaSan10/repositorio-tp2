package ar.edu.unju.fi.service;

import java.util.List;
import ar.edu.unju.fi.entity.Servicio;

public interface IServicioService {
	
	public List<Servicio> obtenerServicios();
	
	public Servicio obtenerServicio();
	
	public void guardarServicio(Servicio servicio);
	
	public void actualizarServicio(Servicio servicioModificado);
	
	public void eliminarServicio(Long id);
	
	public Servicio buscarServicio(Long id);
		
	public List<Servicio> obtenerServiciosSegunDia(String dia);
}