package com.oyd.weather.entity;

import java.time.LocalDateTime;
import java.util.*;

public class FutureWeatherForcastResponse {

	List<DailyWeatherInfo> weatherForcast;

	public FutureWeatherForcastResponse() {
		
	}
	
	public List<DailyWeatherInfo> getWeatherForcast() {
		return weatherForcast;
	}

	public void setWeatherForcast(List<DailyWeatherInfo> weatherForcast) {
		this.weatherForcast = weatherForcast;
	}
	
	public void deserialize(WeatherResponse response) {
		List<DailyWeatherInfo> weatherForcast = new ArrayList<>();
		
		List<DateValuePair> tempuratureData = new ArrayList<>();
		List<DateValuePair> precipitationData = new ArrayList<>(); 
		
		
		for(int index = 0; index < response.getWeatherData().size(); index++) {
			if(response.getWeatherData().get(index).getParamater().equalsIgnoreCase("t_2m:F")) {
				tempuratureData = response.getWeatherData().get(index).getCoordinates().get(0).getDates();
				System.out.println("the temperatureData is " + tempuratureData);
			}
			if(response.getWeatherData().get(index).getParamater().equalsIgnoreCase("precip_24h:mm")) {
				precipitationData = response.getWeatherData().get(index).getCoordinates().get(0).getDates();
				System.out.println("the rainfall data is " + precipitationData);
			}
		}
		
		for(int index = 0; index < tempuratureData.size(); index ++) {
			DailyWeatherInfo info = new DailyWeatherInfo();
			String date = tempuratureData.get(index).getDate();
			date = date.substring(0, date.length()-1);
			info.setDate(LocalDateTime.parse(date));
			info.setDayOfTheWeek(info.getDate().getDayOfWeek().toString());
			info.setRainfall(Double.parseDouble(precipitationData.get(index).getValue()));
			info.setTempInF(Double.parseDouble(tempuratureData.get(index).getValue()));
			
			if(info.getTempInF() >= 15 && info.getRainfall() < 0.1) {
				info.setOutdoorLesson(true);
			}
			
			weatherForcast.add(info);
		}
		
		this.setWeatherForcast(weatherForcast);
	}
}
