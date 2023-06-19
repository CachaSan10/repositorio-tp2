package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "productos")
public class Producto {
	
	

	//Representa el id de proiducto
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "producto_id")
	private Long id;
	
	//Representa el nombre de producto
	@NotEmpty(message="El nombre del producto no puede estar vacio")
	@Size(min=3, max=20,message="El nombre del producto debe tener entre 3 y 20 caracteres")
	@Column(name = "producto_nombre")
	private String nombreProducto;
	
	//Representa la categoria de producto
	@NotEmpty(message="La categoria del producto no puede estar vacio")
	@Size(min=3, max=10,message="La categoria del producto debe tener entre 3 y 10 caracteres")
	private String categoriaProducto;
	
	
	//Representa el precio de producto
	@NotEmpty(message="El precio de producto no puede estar vacio")
	@Positive(message = "El precio es un numero positivo")
	@Column(name = "producto_nombre")
	private double precioProducto;
	
	//Representa el descuento de producto
	@NotEmpty(message="El descuento de producto no puede estar vacio")
	@PositiveOrZero(message = "el descuento es un numero positivo o 0")
	@Max(message = "El descuento no debe ser mayor a 50",value = 50)
	@Column(name = "producto_descuento")
	private int descuentoProducto;
	
	
	//Representa el estado de producto
			@Column(name = "estado")
			private boolean estado;
			
	@OneToOne()
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
		
	/**
	 * Constructor por defecto
	 */
	public Producto() {
	}

	/**
	 * Contructor con parametros
	 * @param id numero de producto
	 * @param nombreProducto nombre de producto
	 * @param categoriaProducto categoria de producto(Alimento, Juguete, Vestimenta, Cuidado)
	 * @param precioProducto precio de producto
	 * @param descuentoProducto descuento de producto(0-50)
	 * @param representa el estado de producto
	 */
	public Producto(Long id,
			@NotEmpty(message = "El nombre del producto no puede estar vacio") @Size(min = 3, max = 20, message = "El nombre del producto debe tener entre 3 y 20 caracteres") String nombreProducto,
			@NotEmpty(message = "La categoria del producto no puede estar vacio") @Size(min = 3, max = 10, message = "La categoria del producto debe tener entre 3 y 10 caracteres") String categoriaProducto,
			@NotEmpty(message = "El precio de producto no puede estar vacio") @Positive(message = "El precio es un numero positivo") double precioProducto,
			@NotEmpty(message = "El descuento de producto no puede estar vacio") @PositiveOrZero(message = "el descuento es un numero positivo o 0") @Max(message = "El descuento no debe ser mayor a 50", value = 50) int descuentoProducto,
			boolean estado, Categoria categoria) {
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.categoriaProducto = categoriaProducto;
		this.precioProducto = precioProducto;
		this.descuentoProducto = descuentoProducto;
		this.estado = estado;
		this.categoria = categoria;
	}
	
	
	
	
	
	/**
	 * Metodo que retorna el id de producto
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	

	/**
	 * Metodo que modifica el id de producto
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo que retorna el nombre de producto
	 * @return nombre de producto
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}

	/**
	 * Metodo que modifica el nombre de producto
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
	 * Metodo que retorna el precio de producto
	 * @return precio de producto
	 */
	public double getPrecioProducto() {
		return precioProducto;
	}
	/**
	 * Metodo que modifica el precio de producto
	 * @param precioProducto
	 */
	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}
	/**
	 * Metodo que retorna el descuento de producto
	 * @return descuento de producto
	 */
	public int getDescuentoProducto() {
		return descuentoProducto;}
	/**
	 * Metodo que modifica el descuento de producto
	 * @param descuentoProducto
	 */
	public void setDescuentoProducto(int descuentoProducto) {
		this.descuentoProducto = descuentoProducto;
	}
	/**
	 * Metodo que calcula el precio de producto con descuento
	 * @return calculo de descuento
	 */
	public double calcularDescuento() {
		double resultado= (descuentoProducto/(double)100)*precioProducto;
		return precioProducto-resultado;
	}

	/**
	 * Metodo que retorna el estado de producto
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}

	/**
	 * Metodo que modifica el estado de producto
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombreProducto=" + nombreProducto + ", categoriaProducto=" + categoriaProducto
				+ ", precioProducto=" + precioProducto + ", descuentoProducto=" + descuentoProducto + ", estado="
				+ estado + "]";
	}
	
	
}
