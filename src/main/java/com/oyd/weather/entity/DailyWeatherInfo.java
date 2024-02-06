package com.oyd.weather.entity;

import java.time.LocalDateTime;

public class DailyWeatherInfo {

	private double tempInF;
	private double rainfall; //in mm
	private boolean OutdoorLesson = false;
	private String dayOfTheWeek;
	private LocalDateTime date;
	
	public DailyWeatherInfo(double tempInF, double rainfall, boolean outdoorLesson, String dayOfTheWeek,
			LocalDateTime date) {
		super();
		this.tempInF = tempInF;
		this.rainfall = rainfall;
		OutdoorLesson = outdoorLesson;
		this.dayOfTheWeek = dayOfTheWeek;
		this.date = date;
	}


	public DailyWeatherInfo(){
		
	}
	
	
	public double getTempInF() {
		return tempInF;
	}
	
	public void setTempInF(double tempInF) {
		this.tempInF = tempInF;
	}
	
	public double getRainfall() {
		return rainfall;
	}
	
	public void setRainfall(double rainfall) {
		this.rainfall = rainfall;
	}
	
	public boolean isOutdoorLesson() {
		return OutdoorLesson;
	}
	
	public void setOutdoorLesson(boolean outdoorLesson) {
		OutdoorLesson = outdoorLesson;
	}
	
	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}
	
	public void setDayOfTheWeek(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
}
