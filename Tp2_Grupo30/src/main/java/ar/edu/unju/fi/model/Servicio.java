package ar.edu.unju.fi.model;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
public class Servicio {
	
	//Se autogenera.
	/**Representa el identificador unico del servicio*/
	private int id;
	
	/**Representa el horario de inicio del servicio*/
	@DateTimeFormat(pattern = "hh:mm")
	@NotNull(message="Debe ingresar una hora de inicio")
	private LocalTime startTime;
	/**Representa el horario de fin del servicio*/
	@DateTimeFormat(pattern = "hh:mm")
	@NotNull(message="Debe ingresar una hora de fin")
	private LocalTime finishTime;
	/**Representa los nombres del paseador/paseadora*/
	@NotBlank(message="Debe ingresar los nombres")
	@Size(min=3,max=30, message="Los nombres deben tener entre 3 y 30 caracteres")
	@Pattern(regexp="[a-zA-Z]+", message="Los nombres solo pueden contener letras")
	private String firstName;
	/**Representa el apellido del paseador/paseadora*/
	@NotBlank(message="Debe ingresar un apellido")
	@Size(min=3,max=20, message="El apellido debe tener entre 3 y 30 caracteres")
	@Pattern(regexp="[a-zA-Z]+", message="El apellido solo puede contener letras")
	private String lastName;
	/**Representa el dia del servicio*/
	@NotBlank(message="Debe seleccionar un día")
	private String day;
	
	//-----------------Constructores--------------------
	/**
	 * Constructor sin parametros
	 */
	public Servicio() {

	}
	/**
	 * Contructor con parametros
	 * @param id numero del servicio
	 * @param startTime horario de inicio del servicio
	 * @param finishTime horario de fin del servicio
	 * @param firstName nombres del paseador o paseadora responsable
	 * * @param lastName apellido del paseador o paseadora responsable
	 * @param day dia de la semana en que se realiza el servicio de paseo
	 */
	public Servicio(int id, LocalTime startTime, LocalTime finishTime, String firstName,String lastName, String day) {
		this.id = id;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.firstName = firstName;
		this.lastName = lastName;
		this.day = day;
	}
	/**
	 * Creacion de los getters and Setter de los atributos de la clase Servicio.
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public LocalTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}


	public LocalTime getFinishTime() {
		return finishTime;
	}


	public void setFinishTime(LocalTime finishTime) {
		this.finishTime = finishTime;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

}
