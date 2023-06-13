package ar.edu.unju.fi.listas;

import java.util.ArrayList;
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
	public static int id;
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
	
}
