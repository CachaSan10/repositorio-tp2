package ar.edu.unju.fi.model;


public class Servicio {
	private String id;
	private String startTime;
	private String finishTime;
	private String fullName;
	private String day;
	
	public Servicio() {
		
	}
	public Servicio(String id, String startTime, String finishTime, String fullName, String day) {
		this.id = id;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.fullName = fullName;
		this.day = day;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getFinishTime() {
		return finishTime;
	}


	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
