package ar.edu.unju.fi.model;

public class Producto {
	private int id;
	private String nombreProducto;
	private String categoriaProducto;
	private double precioProducto;
	private int descuentoProducto;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(int id, String nombreProducto, String categoriaProducto, double precioProducto,
			int descuentoProducto) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.categoriaProducto = categoriaProducto;
		this.precioProducto = precioProducto;
		this.descuentoProducto = descuentoProducto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(String categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}

	public double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public int getDescuentoProducto() {
		return descuentoProducto;
	}

	public void setDescuentoProducto(int descuentoProducto) {
		this.descuentoProducto = descuentoProducto;
	}
	
	public double calcularDescuento() {
		double resultado= (descuentoProducto/(double)100)*precioProducto;
		return precioProducto-resultado;
	}
}
