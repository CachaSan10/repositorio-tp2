package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Producto;

public class ListaProducto {
	
	private List<Producto> productos;
	
	public ListaProducto() {
		// TODO Auto-generated constructor stub
		productos = new ArrayList<Producto>();
		productos.add(new Producto(10001, "VitalCan Premium Perro 20kg", "VitalCan Premium Perro 20kg", 6500));
		productos.add(new Producto(10002, "Raza Perro Adulto Carne 21 Kg", "Raza Perro Adulto Carne 21 Kg", 5390));
		productos.add(new Producto(10003, "HOP GATITO 7.5Kg", "HOP GATITO 7.5Kg", 3200));
		productos.add(new Producto(10004, "Lata Agility Gato Sabor Carne Vacuna 340gr", "Lata Agility Gato Sabor Carne Vacuna 340gr", 500));
		productos.add(new Producto(10005, "Comedero Doble Cuadrado", "Comedero Doble Cuadrado", 290));
		productos.add(new Producto(10006, "Comedero Circular Chico", "Comedero Circular Chico", 110));
		productos.add(new Producto(10007, "Kit Sanitario Grande", "Kit Sanitario Grande", 1100));
		productos.add(new Producto(10008, "Hueso Suelto 4/5", "Hueso Suelto 4/5", 140));
		
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void addProducto(Producto producto) {
		productos.add(producto);
	}
	
}
