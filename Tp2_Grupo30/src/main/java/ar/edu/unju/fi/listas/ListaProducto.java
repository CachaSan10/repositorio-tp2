package ar.edu.unju.fi.listas;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Producto;

/**
 * 
 * @author Acosta Jose David
 *
 */

@Component
public class ListaProducto {
	
	private List<Producto> productos;
	public static Long id;
	
	public ListaProducto() {
		// TODO Auto-generated constructor stub
	
	
		
		
	}
	/**
	 * 
	 * @return lista de productos
	 */
	public List<Producto> getProductos() {
		return productos;
	}
	/**
	 * 
	 * @param productos
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
