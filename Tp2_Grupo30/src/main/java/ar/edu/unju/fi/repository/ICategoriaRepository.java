package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Categoria;
import java.util.List;


public interface ICategoriaRepository extends CrudRepository<Categoria, Long> {

	public List<Categoria> findByEstado(boolean estado);
}
