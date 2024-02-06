package com.oyd.weather.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


public class RequestEntityUtil {

	public HttpEntity<String> createEntity(String name, String value){
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", name + " " + value);
		headers.setContentType(MediaType.APPLICATION_JSON);
		System.out.println(headers.toString());
	    HttpEntity<String> entity = new HttpEntity<>(headers);
	    return entity;
	}
}
