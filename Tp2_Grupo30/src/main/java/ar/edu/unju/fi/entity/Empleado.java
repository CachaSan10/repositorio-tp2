package ar.edu.unju.fi.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Component
@Entity
@Table(name="empleados")
public class Empleado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="empl_id")
	private Long id;
	/**Representa los nombres del paseador/paseadora*/
	@NotBlank(message="Debe ingresar los nombres")
	@Size(min=3,max=30, message="Los nombres deben tener entre 3 y 30 caracteres")
	@Pattern(regexp="[a-z A-Z]*", message="Los nombres solo pueden contener letras")
	@Column(name= "empl_nombres",nullable = false)
	private String names;
	/**Representa el apellido del paseador/paseadora*/
	@NotBlank(message="Debe ingresar un apellido")
	@Size(min=3,max=20, message="El apellido debe tener entre 3 y 30 caracteres")
	@Pattern(regexp="[a-z A-Z]*", message="El apellido solo puede contener letras")
	@Column(name= "empl_apellidos",nullable = false)
	private String lastName;
	/**Representa el dni del paseador/a o encargado/a*/
	@NotNull(message="Debe ingresar un dni")
	@Column(name= "empl_dni",length =10, nullable = false, unique=true)
	private Integer dni;
	/**Representa la fecha de nacimiento del paseador/a o encargado/a*/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="Debe ingresar la fecha de nacimiento")
	@Column(name= "empl_fecha de Nac", nullable = false)
	private Date dateOfBirth;
	/**Representa la dirección del paseador/a o encargado/a*/
	@NotBlank(message="Debe ingresar una dirección")
	@Column(name="empl_dirección", length =50, nullable = false)
	private String address;
	/**Representa la categoria del Empleado/a*/
	@NotBlank(message="Debe ingresar una categoria")
	@Column(name="empl_categoria", length =30, nullable = false)
	private String category;
	/**Representa el telefono del paseador/a o encargado/a*/
	@NotBlank(message="Debe ingresar una teléfono")
	@Column(name="empl_telefono", length =20, nullable = false)
	private String phone;
	/**Representa si el estado es activo o pasivo del paseador/a o encargado/a*/
	@Column(name="empl_estado")
	private boolean status;
	
	
	/**
	 * Constructor por defecto
	 */
	public Empleado() {
	}
	
	/**
	 * @param id
	 * @param names
	 * @param lastName
	 * @param dni
	 * @param dateOfBirth
	 * @param address
	 * @param category
	 * @param phone
	 * @param status
	 */
	public Empleado(Long id, String names, String lastName, Integer dni, Date dateOfBirth,
			String address, String category, String phone, boolean status) {
		this.id = id;
		this.names = names;
		this.lastName = lastName;
		this.dni = dni;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.category = category;
		this.phone = phone;
		this.status = status;
		
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the names
	 */
	public String getNames() {
		return names;
	}
	/**
	 * @param names the names to set
	 */
	public void setNames(String names) {
		this.names = names;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the dni
	 */
	public Integer getDni() {
		return dni;
	}
	/**
	 * @param dni the dni to set
	 */
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the employeeCategory
	 */
	
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", names=" + names + ", lastName=" + lastName + ", dni=" + dni + ", dateOfBirth="
				+ dateOfBirth + ", address=" + address + ", category=" + category + ", phone=" + phone + ", status="
				+ status + "]";
	}
	
}
