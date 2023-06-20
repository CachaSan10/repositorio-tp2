package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.entity.Producto;
import java.util.List;

@Repository
public interface IProductoRepository extends CrudRepository<Producto, Long> {

	public List<Producto> findByEstado(boolean estado); 
	public List<Producto> findByCategoria(Categoria categoria);
}
