package ar.edu.unju.fi.entity;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Component
@Entity
@Table(name = "servicios")
public class Servicio {
	
	//Se autogenera.
	/**Representa el identificador unico del servicio*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "serv_id")
	private Long id;
	
	/**Representa el horario de inicio del servicio*/
	@DateTimeFormat(pattern = "hh:mm")
	@NotNull(message="Debe ingresar una hora de inicio")
	@Column(name= "serv_inicio", nullable = false)
	private LocalTime startTime;
	/**Representa el horario de fin del servicio*/
	@DateTimeFormat(pattern = "hh:mm")
	@NotNull(message="Debe ingresar una hora de fin")
	@Column(name= "serv_fin", nullable = false)
	private LocalTime finishTime;
	/**Representa el día del servicio*/
	@NotBlank(message="Debe seleccionar un día")
	@Column(name= "serv_días", nullable = false)
	private String day;
	@Column(name="serv_estado")
	private boolean status;
	@NotNull(message="Debe seleccionar un Empleado")
	@ManyToOne(fetch=FetchType.LAZY)//Eager cargamento anticipado con LAZY corregimos eso
	@JoinColumn(name="empleado")
	private Empleado empleado;
		
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
	public Servicio(Long id, LocalTime startTime, LocalTime finishTime, String day, Empleado empleado) {
		this.id = id;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.day = day;
		this.empleado = empleado;
	}
	/**
	 * Creacion de los getters and Setter de los atributos de la clase Servicio.
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	/**
	 * @return the empleado
	 */
	public Empleado getEmployee() {
		return empleado;
	}
	/**
	 * @param empleado the empleado to set
	 */
	public void setEmployee(Empleado empleado) {
		this.empleado = empleado;
	}

	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Servicio [id=" + id + ", startTime=" + startTime + ", finishTime=" + finishTime + ", day=" + day
				+ ", status=" + status + ", empleado=" + empleado + "]";
	}
	
	
}
