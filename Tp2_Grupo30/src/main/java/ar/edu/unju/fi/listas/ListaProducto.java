package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Producto;

public class ListaProducto {
	
	private List<Producto> productos;
	static int contador;
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
		
		contador=productos.size()+1;
		
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void addProducto(Producto producto) {
		producto.setId(contador++);
		productos.add(producto);
	}
	
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
	
	public void deleteProducto(int id) {
		for(Producto producto: getProductos()) {
	    	if(producto.getId()==id) {
	    		getProductos().remove(producto);
	    		break;
	    	}
	    }
	}
}
