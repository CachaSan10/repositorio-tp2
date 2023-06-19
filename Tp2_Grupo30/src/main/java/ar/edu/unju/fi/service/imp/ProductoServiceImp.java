package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.service.IProductoService;

@Service("productoServiceListaImp")
public class ProductoServiceImp implements IProductoService{
	
	@Autowired
	private ListaProducto listaProductos;
	

	@Override
	public List<Producto> getListaProducto() {
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
		getListaProducto().add(producto);
	}

	/**
	 * Metodo que actualiza los valores del producto que se modifico
	 * @param productoModificado
	 */
	@Override
	public void modificarProducto(Producto productoModificado) {
		for(Producto producto: getListaProducto()) {
	    	if(producto.getId() == productoModificado.getId()) {
	    		producto.setNombreProducto(productoModificado.getNombreProducto());
	    		producto.setCategoriaProducto(productoModificado.getCategoriaProducto());
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
	public void eliminarProducto(int id) {
		for(Producto producto: getListaProducto()) {
	    	if(producto.getId()==id) {
	    		getListaProducto().remove(producto);
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
	public Producto buscarProducto(int id) {
		Producto productoEncontrado = new Producto();
		for(Producto unProducto: getListaProducto()) {
			if(unProducto.getId()==id) {
				productoEncontrado=unProducto;
				break;
			}
		}
		return productoEncontrado;
	}
	
	
}
