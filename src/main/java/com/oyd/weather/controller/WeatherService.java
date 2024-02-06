package com.oyd.weather.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oyd.weather.api.MeteomaticAuthApi;
import com.oyd.weather.api.MeteomaticsApi;
import com.oyd.weather.configuration.MeteomaticAuthTokenConfig;
import com.oyd.weather.configuration.MeteomaticsConfig;
import com.oyd.weather.entity.FutureWeatherForcastResponse;
import com.oyd.weather.entity.WeatherResponse;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/weather")
public class WeatherService {

	@Autowired
	private MeteomaticsConfig config;

	@Autowired
	private MeteomaticAuthTokenConfig authConfig; 
	
	private static final Logger log = LoggerFactory.getLogger(WeatherService.class);
	
	private MeteomaticsApi weatherApi = new MeteomaticsApi();
	private MeteomaticAuthApi authApi = new MeteomaticAuthApi();
	
	@GetMapping("/current")
	public WeatherResponse getCurrentWeather() {
		String url = config.getWeatherNowUrl();
		//String authUrl = authConfig.getUrl();
		//String token = authApi.fetchBearer(authUrl, "Basic", config.getUserAndPassword());
		String token = getAuthToken();
		System.out.println("the token after the api call is " + token);
		WeatherResponse response = weatherApi.getWeather(url, token);
		response.updateOutdoorLessonStatus();
		return response;
	}
	
	@GetMapping("/weekly/forcast")
	public FutureWeatherForcastResponse getForcast() {
		FutureWeatherForcastResponse futureWeatherForcast = new FutureWeatherForcastResponse();
		String url = config.getDateRangeUrl(7);
		String token = getAuthToken();
		WeatherResponse response = weatherApi.getWeather(url, token);
		futureWeatherForcast.deserialize(response);
		return futureWeatherForcast;
		
	}
	
	@GetMapping("/token")
	public String getAuthToken() {
		String url = authConfig.getUrl();
		return authApi.fetchBearer(url, "Basic", config.getUserAndPassword());
	}
	
}
