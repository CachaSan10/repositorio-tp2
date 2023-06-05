package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Producto;

/**
 * 
 * @author Acosta Jose David
 *
 */

@Component
public class ListaProducto {
	
	private List<Producto> productos;
	static int id;
	public ListaProducto() {
		// TODO Auto-generated constructor stub
		productos = new ArrayList<Producto>();
		productos.add(new Producto(1,"VitalCan Premium Perro 20kg", "Alimento", 6500, 0));
		productos.add(new Producto(2,"Raza Perro Adulto Carne 21 Kg", "Alimento", 5390, 10));
		productos.add(new Producto(3,"HOP GATITO 7.5Kg", "Alimento", 3200, 20));
		productos.add(new Producto(4,"Lata Agility Gato Sabor Carne Vacuna 340gr", "Alimento", 500, 0));
		productos.add(new Producto(5,"Comedero Doble Cuadrado", "Cuidado", 290, 0));
		productos.add(new Producto(6,"Comedero Circular Chico", "Cuidado", 110, 0));
		productos.add(new Producto(7,"Kit Sanitario Grande", "Cuidado", 1100, 20));
		productos.add(new Producto(8,"Hueso Suelto 4/5", ", Juguete", 140, 0));
		
		id=8;
		
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
	/**
	 * Metodo que agrega un producto a la lista de productos
	 * @param producto
	 */
	public void addProducto(Producto producto) {
		id++;
		producto.setId(id);
		productos.add(producto);
	}
	/**
	 * 
	 * @param id
	 * @return producto buscado
	 */
	public Producto productoBuscado(int id) {
		Producto productoEncontrado = new Producto();
		for(Producto unProducto: getProductos()) {
			if(unProducto.getId()==id) {
				productoEncontrado=unProducto;
				break;
			}
		}
		return productoEncontrado;
	}
	/**
	 * Metodo que actualiza los valores del producto que se modifico
	 * @param productoModificado
	 */
	public void actualizarProducto(Producto productoModificado) {
		for(Producto producto: getProductos()) {
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
	public void deleteProducto(int id) {
		for(Producto producto: getProductos()) {
	    	if(producto.getId()==id) {
	    		getProductos().remove(producto);
	    		break;
	    	}
	    }
	}
}
