package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Empleado;

public interface IEmpleadoService {
	
	public List<Empleado> getLista();
	
	public Empleado getEmpleado(Long id);
	
	public void guardarEmpleado(Empleado empleado);
	
	public void modificarEmpleado(Empleado empleado);
	
	public void eliminarEmpleado(Empleado empleado);
	
	public Empleado buscarEmpleado(Long id);
	
}
