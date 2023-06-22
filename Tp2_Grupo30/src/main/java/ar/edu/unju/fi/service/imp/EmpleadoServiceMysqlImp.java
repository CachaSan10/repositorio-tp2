package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Empleado;
import ar.edu.unju.fi.repository.IEmpleadoRepository;
import ar.edu.unju.fi.service.IEmpleadoService;
@Service
public class EmpleadoServiceMysqlImp implements IEmpleadoService {
	
	@Autowired
	private IEmpleadoRepository empleadoRepository;
	@Autowired
	private Empleado empleado;
	
	@Override
	public List<Empleado> obtenerEmpleados() {
		return empleadoRepository.findByEstado(true);
	}
	@Override
	public Empleado buscarEmpleado(Long id) {
		return empleadoRepository.findById(id).get();
	}

	@Override
	public void guardarEmpleado(Empleado empleado) {
		empleado.setEstado(true);
		empleadoRepository.save(empleado);

	}

	@Override
	public void modificarEmpleado(Empleado empleado) {
		empleadoRepository.save(empleado);

	}

	@Override
	public void eliminarEmpleado(Long id) {
		//Se realiza una eliminacion logica
		empleado.setEstado(false);
		empleadoRepository.save(empleado);
	}

	@Override
	public Empleado obtenerEmpleado() {
		return empleado;
	}
	
}
