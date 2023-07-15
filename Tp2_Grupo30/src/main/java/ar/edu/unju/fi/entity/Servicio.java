package ar.edu.unju.fi.entity;

import java.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Clase que representa el servicio en el sistema
 */
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
	private LocalTime inicioHorario;
	/**Representa el horario de fin del servicio*/
	@DateTimeFormat(pattern = "hh:mm")
	@NotNull(message="Debe ingresar una hora de fin")
	@Column(name= "serv_fin", nullable = false)
	private LocalTime finHorario;
	/**Representa el día del servicio*/
	@NotBlank(message="Debe seleccionar un día")
	@Column(name= "serv_días", nullable = false)
	private String dia;
	/**Representa la disponibilidad del servicio en la base de datos */
	@Column(name="serv_estado")
	private boolean estado;
	@NotNull(message="Debe seleccionar un Empleado")

	@OneToOne()
	@JoinColumn(name="empleado_id")
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
	 * @param inicioHorario horario de inicio del servicio
	 * @param finHorario horario de fin del servicio
	 * @param dia dia de la semana en que se realiza el servicio de paseo
	 * @param empleado nombre y apellido del paseador o paseadora responsable
	 */
	public Servicio(Long id, LocalTime inicioHorario, LocalTime finHorario, String dia, boolean estado,
			Empleado empleado) {
		this.id = id;
		this.inicioHorario = inicioHorario;
		this.finHorario = finHorario;
		this.dia = dia;
		this.estado = estado;
		this.empleado = empleado;
	}
	/** Creacion de los getters and Setter de los atributos de la clase Servicio.*/
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
	 * @return the inicioHorario
	 */
	public LocalTime getInicioHorario() {
		return inicioHorario;
	}
	/**
	 * @param inicioHorario the inicioHorario to set
	 */
	public void setInicioHorario(LocalTime inicioHorario) {
		this.inicioHorario = inicioHorario;
	}
	/**
	 * @return the finHorario
	 */
	public LocalTime getFinHorario() {
		return finHorario;
	}
	/**
	 * @param finHorario the finHorario to set
	 */
	public void setFinHorario(LocalTime finHorario) {
		this.finHorario = finHorario;
	}
	/**
	 * @return the dia
	 */
	public String getDia() {
		return dia;
	}
	/**
	 * @param dia the dia to set
	 */
	public void setDia(String dia) {
		this.dia = dia;
	}
	/**
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	/**
	 * @return the empleado
	 */
	public Empleado getEmpleado() {
		return empleado;
	}
	/**
	 * @param empleado the empleado to set
	 */
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Servicio [id=" + id + ", inicioHorario=" + inicioHorario + ", finHorario=" + finHorario + ", dia=" + dia
				+ ", estado=" + estado + ", empleado=" + empleado + "]";
	}
	
}
