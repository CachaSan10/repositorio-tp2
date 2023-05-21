package ar.edu.unju.fi.model;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class Servicio {
	private int id;
	@DateTimeFormat(pattern = "hh:mm")
	private LocalTime startTime;
	@DateTimeFormat(pattern = "hh:mm")
	private LocalTime finishTime;
	private String fullName;
	private String day;

	public Servicio() {

	}

	
	public Servicio(int id, LocalTime startTime, LocalTime finishTime, String fullName, String day) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.fullName = fullName;
		this.day = day;
	}


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
