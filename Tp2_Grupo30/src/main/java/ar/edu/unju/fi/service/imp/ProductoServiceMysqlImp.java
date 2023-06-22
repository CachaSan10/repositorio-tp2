package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;

@Service("productoServiceMysqlImp")
public class ProductoServiceMysqlImp implements IProductoService {

	@Autowired
	private Producto producto;
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Override
	public List<Producto> obtenerListaProducto() {
		return productoRepository.findByEstado(true);
	}

	@Override
	public void guardarProducto(Producto producto) {
		producto.setEstado(true);
		productoRepository.save(producto);
	}

	@Override
	public void modificarProducto(Producto productoModificado) {
		productoModificado.setEstado(true);
		productoRepository.save(productoModificado);
	}

	@Override
	public void eliminarProducto(Long id) {
		Producto unProducto = new Producto();
		unProducto = buscarProducto(id);
		unProducto.setEstado(false);
		productoRepository.save(unProducto);
	}

	@Override
	public Producto buscarProducto(Long id) {
		return productoRepository.findById(id).get();
	}

	@Override
	public List<Producto> obtenerListaProductoSegunCategoria(Categoria categoria) {
		return productoRepository.findByCategoria(categoria);
	}

	@Override
	public Producto obtenerProducto() {
		return producto;
	}

}
