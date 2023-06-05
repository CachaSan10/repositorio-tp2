package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

/**
 * 
 * @author Acosta Jose David 
 */
@Component
public class Producto {
	private int id;
	@NotEmpty(message="El nombre del producto no puede estar vacio")
	@Size(min=3, max=20,message="El nombre del producto debe tener entre 3 y 20 caracteres")
	private String nombreProducto;
	@NotEmpty(message="La categoria del producto no puede estar vacio")
	@Size(min=3, max=10,message="La categoria del producto debe tener entre 3 y 10 caracteres")
	private String categoriaProducto;
	@NotEmpty(message="El precio de producto no puede estar vacio")
	@Positive(message = "El precio es un numero positivo")
	private double precioProducto;
	@NotEmpty(message="El descuento de producto no puede estar vacio")
	@PositiveOrZero(message = "el descuento es un numero positivo o 0")
	@Max(message = "El descuento no debe ser mayor a 50",value = 50)
	private int descuentoProducto;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Contructor con parametros
	 * @param id numero de producto
	 * @param nombreProducto nombre de producto
	 * @param categoriaProducto categoria de producto(Alimento, Juguete, Vestimenta, Cuidado)
	 * @param precioProducto precio de producto
	 * @param descuentoProducto descuento de producto(0-50)
	 */
	public Producto(int id, String nombreProducto, String categoriaProducto, double precioProducto,
			int descuentoProducto) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.categoriaProducto = categoriaProducto;
		this.precioProducto = precioProducto;
		this.descuentoProducto = descuentoProducto;
	}
	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return nombre de producto
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}

	/**
	 * 
	 * @param nombreProducto
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	/**
	 * 
	 * @return categoria de producto
	 */
	public String getCategoriaProducto() {
		return categoriaProducto;
	}
	/**
	 * 
	 * @param categoriaProducto
	 */
	public void setCategoriaProducto(String categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}
	/**
	 * 
	 * @return precio de producto
	 */
	public double getPrecioProducto() {
		return precioProducto;
	}
	/**
	 * 
	 * @param precioProducto
	 */
	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}
	/**
	 * 
	 * @return descuento de producto
	 */
	public int getDescuentoProducto() {
		return descuentoProducto;}
	/**
	 * 
	 * @param descuentoProducto
	 */
	public void setDescuentoProducto(int descuentoProducto) {
		this.descuentoProducto = descuentoProducto;
	}
	/**
	 * 
	 * @return calculo de descuento
	 */
	public double calcularDescuento() {
		double resultado= (descuentoProducto/(double)100)*precioProducto;
		return precioProducto-resultado;
	}
}
