package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Categoria;
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
	@Autowired
	private Categoria categoria;
	
	public ListaProducto() {
		// TODO Auto-generated constructor stub
		productos = new ArrayList<Producto>();
		categoria.setId(1L);
		categoria.setNombre(null);
	
		
		id=8L;
		
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
