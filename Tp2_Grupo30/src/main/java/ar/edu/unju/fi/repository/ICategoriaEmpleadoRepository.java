package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.CategoriaEmpleado;

import java.util.List;

@Repository
public interface ICategoriaEmpleadoRepository extends CrudRepository<CategoriaEmpleado, Long> {

	public List<CategoriaEmpleado> findByEstado(boolean estado);
}
