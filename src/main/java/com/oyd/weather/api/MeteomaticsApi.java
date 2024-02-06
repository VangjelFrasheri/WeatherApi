package com.oyd.weather.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.oyd.weather.entity.WeatherResponse;
import com.oyd.weather.util.RequestEntityUtil;


public class MeteomaticsApi {

	private RestTemplate restTemplate = new RestTemplate();
	private static final Logger log = LoggerFactory.getLogger(MeteomaticsApi.class);
	
	private RequestEntityUtil entityUtil = new RequestEntityUtil();

	public WeatherResponse getWeather(String url, String token) {
		WeatherResponse responseBody = new WeatherResponse();
		log.info("the url is " + url);
		try {
			HttpEntity<String> entity = entityUtil.createEntity("Bearer", token);
			ResponseEntity<WeatherResponse> response = restTemplate.exchange(
					url,
					HttpMethod.GET,
					entity,
					WeatherResponse.class
				);
			responseBody = response.getBody();
			System.out.println(responseBody);
			return responseBody;
		}
		catch(Exception e){  
			log.error("Error in getting weather - Error: " + e);
			throw new ResponseStatusException(
				HttpStatus.INTERNAL_SERVER_ERROR,
				"Exception while calling " + url
				);
		}
	}
	
}
