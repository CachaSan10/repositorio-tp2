package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.repository.ICategoriaRepository;
import ar.edu.unju.fi.service.ICategoriaService;

@Service("categoriaServiceMysqlImp")
public class CategoriaServiceMysqlImp implements ICategoriaService {

	@Autowired
	private Categoria categoria;
	
	@Autowired
	private ICategoriaRepository categoriaRepository;
	
	@Override
	public Categoria getCategoria() {
		return categoria;
	}

	@Override
	public void guardarCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
	}

	@Override
	public void modificarCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
	}

	@Override
	public void eliminarCategoria(Long id) {
		categoriaRepository.deleteById(id);
	}

	@Override
	public Categoria buscarCategoria(Long id) {
		return categoriaRepository.findById(id).get();
	}

	@Override
	public List<Categoria> getLista() {
		return categoriaRepository.findByEstado(true);
	}

}
