package com.oyd.weather.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {

	@JsonProperty("data")
	List<ParamCoordinatePair> weatherData;
	private boolean isOutdoorLesson = false;

	
	public WeatherResponse() {
		
	}
	
	public WeatherResponse(List<ParamCoordinatePair> weatherData) {
		super();
		this.weatherData = weatherData;
	}
	
	public boolean isOutdoorLesson() {
		return isOutdoorLesson;
	}

	public void setOutdoorLesson(boolean isOutdoorLesson) {
		this.isOutdoorLesson = isOutdoorLesson;
	}


	public List<ParamCoordinatePair> getWeatherData() {
		return weatherData;
	}

	public void setWeatherData(List<ParamCoordinatePair> weatherData) {
		this.weatherData = weatherData;
	}
	
	public void updateOutdoorLessonStatus() {
		
		double tempInF = 0.0;
		double rainfall = 0.0;
		
		for(int index = 0; index < this.weatherData.size(); index++) {
			if(this.weatherData.get(index).getParamater().equalsIgnoreCase("t_2m:F")) {
				tempInF = Double.parseDouble(this.weatherData.get(index).getCoordinates().get(0).getDates().get(0).getValue());
				System.out.println("the temperatur in F is " + tempInF + " degrees");
			}
			if(this.weatherData.get(index).getParamater().equalsIgnoreCase("precip_24h:mm")) {
				rainfall = Double.parseDouble(this.weatherData.get(index).getCoordinates().get(0).getDates().get(0).getValue());
				System.out.println("the rainfall is " + rainfall + "mm");
			}
		}
		
		if(tempInF >= 65 && rainfall < 0.1) {
			this.setOutdoorLesson(true);
		}
		
	}
	

}
