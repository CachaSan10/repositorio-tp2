package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.service.IProductoService;

@Service("productoServiceListaImp")
public class ProductoServiceImp implements IProductoService{
	
	@Autowired
	private ListaProducto listaProductos;
	

	@Override
	public List<Producto> obtenerListaProducto() {
		return listaProductos.getProductos();
	}
	
	/**
	 * Metodo que agrega un producto a la lista de productos
	 * @param producto
	 */
	@Override
	public void guardarProducto(Producto producto) {
		ListaProducto.id++;
		producto.setId(ListaProducto.id);
		obtenerListaProducto().add(producto);
	}

	/**
	 * Metodo que actualiza los valores del producto que se modifico
	 * @param productoModificado
	 */
	@Override
	public void modificarProducto(Producto productoModificado) {
		for(Producto producto: obtenerListaProducto()) {
	    	if(producto.getId() == productoModificado.getId()) {
	    		producto.setNombreProducto(productoModificado.getNombreProducto());
	    		producto.setPrecioProducto(productoModificado.getPrecioProducto());
	    		producto.setDescuentoProducto(productoModificado.getDescuentoProducto());
	    	}
	    }
	}

	/**
	 * Metodo que eliminia un producto
	 * @param id
	 */
	@Override
	public void eliminarProducto(Long id) {
		for(Producto producto: obtenerListaProducto()) {
	    	if(producto.getId()==id) {
	    		obtenerListaProducto().remove(producto);
	    		break;
	    	}
		}
	}

	/**
	 * 
	 * @param id
	 * @return producto buscado
	 */
	@Override
	public Producto buscarProducto(Long id) {
		Producto productoEncontrado = new Producto();
		for(Producto unProducto: obtenerListaProducto()) {
			if(unProducto.getId()==id) {
				productoEncontrado=unProducto;
				break;
			}
		}
		return productoEncontrado;
	}

	@Override
	public List<Producto> obtenerListaProductoSegunCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto obtenerProducto() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
