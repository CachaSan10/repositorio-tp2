package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.entity.Producto;

public interface IProductoService {
	
	public List<Producto> obtenerListaProducto();
	public Producto obtenerProducto();
	public void guardarProducto(Producto producto);
	public void modificarProducto(Producto productoModificado);
	public void eliminarProducto(Long id);
	public Producto buscarProducto(Long id);
	public List<Producto> obtenerListaProductoSegunCategoria(Categoria categoria);
}
