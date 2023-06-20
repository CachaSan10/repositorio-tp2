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
	public List<Empleado> getLista() {
		return empleadoRepository.findByStatus(true);
	}
	@Override
	public Empleado getEmpleado(Long id) {
		return empleadoRepository.findById(id).get();
	}

	@Override
	public void guardarEmpleado(Empleado empleado) {
		empleadoRepository.save(empleado);

	}

	@Override
	public void modificarEmpleado(Empleado empleado) {
		empleadoRepository.save(empleado);

	}

	@Override
	public void eliminarEmpleado(Empleado empleado) {
		//Se realiza una eliminacion logica
		empleado.setStatus(false);
		empleadoRepository.save(empleado);
	}

	@Override
	public Empleado buscarEmpleado(Long id) {
		return empleado;
	}
	
}
