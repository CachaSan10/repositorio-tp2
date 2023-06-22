package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.CategoriaEmpleado;
import ar.edu.unju.fi.repository.ICategoriaEmpleadoRepository;
import ar.edu.unju.fi.service.ICategoriaEmpleadoService;

@Service("categoriaEmpleadoServiceMysqlImp")
public class CategoriaEmpleadoServiceMysqlImp implements ICategoriaEmpleadoService {

	@Autowired
	private CategoriaEmpleado categoriaEmpleado;
	
	@Autowired
	private ICategoriaEmpleadoRepository categoriaEmpleadoRepository;
	
	@Override
	public CategoriaEmpleado obtenerCategoriaEmpleado() {
		return categoriaEmpleado;
	}

	@Override
	public void guardarCategoriaEmpleado(CategoriaEmpleado categoriaEmpleado) {
		categoriaEmpleado.setEstado(true);
		
		categoriaEmpleadoRepository.save(categoriaEmpleado);
	}

	@Override
	public void modificarCategoriaEmpleado(CategoriaEmpleado categoriaEmpleado) {
		categoriaEmpleado.setEstado(true);
		categoriaEmpleadoRepository.save(categoriaEmpleado);
	}

	@Override
	public void eliminarCategoriaEmpleado(Long id) {
		CategoriaEmpleado unaCategoriaEmpleado = new CategoriaEmpleado();
		unaCategoriaEmpleado = buscarCategoriaEmpleado(id);
		unaCategoriaEmpleado.setEstado(false);
		categoriaEmpleadoRepository.save(unaCategoriaEmpleado);
	}

	@Override
	public CategoriaEmpleado buscarCategoriaEmpleado(Long id) {
		return categoriaEmpleadoRepository.findById(id).get();
	}

	@Override
	public List<CategoriaEmpleado> obtenerCategoriasEmpleado() {
		return categoriaEmpleadoRepository.findByEstado(true);
	}

}
