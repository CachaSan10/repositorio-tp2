package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
	@NotEmpty()
	@Pattern(regexp="[a-z A-Z]*", message="")
	@Size(min=6, max=20)
	@Column(name = "producto_nombre")
	private String nombreProducto;
	
	
	//Representa el precio de producto
	@Positive()
	@Column(name = "producto_precio")
	private double precioProducto;
	
	//Representa el descuento de producto
	@PositiveOrZero()
	@Min(value = 0)
	@Max(value = 50)
	@Column(name = "producto_descuento")
	private int descuentoProducto;
	
	
	//Representa el estado de producto
			@Column(name = "estado")
			private boolean estado;
	
	@ManyToOne(fetch=FetchType.LAZY)
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
	 * @param precioProducto precio de producto
	 * @param descuentoProducto descuento de producto(0-50)
	 * @param representa el estado de producto
	 */
	public Producto(Long id,
			@NotEmpty(message = "El nombre del producto no puede estar vacio") @Size(min = 3, max = 20, message = "El nombre del producto debe tener entre 3 y 20 caracteres") String nombreProducto,
			@NotEmpty(message = "El precio de producto no puede estar vacio") @Positive(message = "El precio es un numero positivo") double precioProducto,
			@NotEmpty(message = "El descuento de producto no puede estar vacio") @PositiveOrZero(message = "el descuento es un numero positivo o 0") @Max(message = "El descuento no debe ser mayor a 50", value = 50) int descuentoProducto,
			boolean estado, Categoria categoria) {
		this.id = id;
		this.nombreProducto = nombreProducto;
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

	
	
	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombreProducto=" + nombreProducto + ", precioProducto=" + precioProducto
				+ ", descuentoProducto=" + descuentoProducto + ", estado=" + estado + ", categoria=" + categoria + "]";
	}

	
	
}
