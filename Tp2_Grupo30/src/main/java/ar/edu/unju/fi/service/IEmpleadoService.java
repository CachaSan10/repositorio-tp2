package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Empleado;

public interface IEmpleadoService {
		
	public Empleado obtenerEmpleado();
	
	public void guardarEmpleado(Empleado empleado);
	
	public void modificarEmpleado(Empleado empleado);
	
	public void eliminarEmpleado(Long id);
	
	public Empleado buscarEmpleado(Long id);
	
	public List<Empleado> obtenerEmpleados();
	
}
