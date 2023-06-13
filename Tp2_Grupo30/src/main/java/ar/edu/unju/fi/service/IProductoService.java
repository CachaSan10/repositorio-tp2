package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Producto;

public interface IProductoService {
	
	public List<Producto> getListaProducto();
	public void guardarProducto(Producto producto);
	public void modificarProducto(Producto productoModificado);
	public void eliminarProducto(int id);
	public Producto buscarProducto(int id);
}
