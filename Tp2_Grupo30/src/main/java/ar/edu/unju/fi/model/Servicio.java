package ar.edu.unju.fi.model;


public class Servicio {
	private String id;
	private String fullTime;
	private Date horarioFinal;
	private String fullName;
	private String day;
	
	
	
	public Servicio() {
		
	}
	public Servicio(String id, String fullTime, String fullName, String day) {
		this.id = id;
		this.fullTime = fullTime;
		this.fullName = fullName;
		this.day = day;
	}	
		
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFullTime() {
		return fullTime;
	}
	public void setFullTime(String fullTime) {
		this.fullTime = fullTime;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	
}
