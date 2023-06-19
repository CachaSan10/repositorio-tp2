package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Producto;
import java.util.List;


public interface IProductoRepository extends CrudRepository<Producto, Long> {

	public List<Producto> findByEstado(boolean estado); 
}
