package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.CategoriaEmpleado;
@Service
public interface ICategoriaEmpleadoService {
	
	public CategoriaEmpleado obtenerCategoriaEmpleado();
	
	public void guardarCategoriaEmpleado(CategoriaEmpleado categoria);
	
	public void modificarCategoriaEmpleado(CategoriaEmpleado categoria);
	
	public void eliminarCategoriaEmpleado(Long id);
	
	public CategoriaEmpleado buscarCategoriaEmpleado(Long id);
	
	public List<CategoriaEmpleado> obtenerCategoriasEmpleado();
 
}
