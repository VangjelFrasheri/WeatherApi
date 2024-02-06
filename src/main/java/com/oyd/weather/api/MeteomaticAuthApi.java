package com.oyd.weather.api;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.oyd.weather.entity.OAuthToken;
import com.oyd.weather.util.RequestEntityUtil;

public class MeteomaticAuthApi {

	
	private RestTemplate restTemplate = new RestTemplate();
	private static final Logger log = LoggerFactory.getLogger(MeteomaticAuthApi.class);

	private RequestEntityUtil entityUtil = new RequestEntityUtil();
	
	
	
	public String fetchBearer(String url, String entityName, String entityValue) {
		System.out.println("the url is " + url);
		System.out.println("the entityName is " + entityName);
		System.out.println("the entityValue is " + entityValue);
		//String encodedvalue = Base64.getEncoder().encodeToString(entityValue.getBytes());
		//System.out.println("the entityValue encoded is " + encodedvalue);
		OAuthToken token = new OAuthToken();
		try {
			HttpEntity<String> entity = entityUtil.createEntity(entityName, entityValue);
			ResponseEntity<OAuthToken> response = restTemplate.exchange(
					url,
					HttpMethod.GET,
					entity,
					OAuthToken.class
					);
			token = response.getBody();
			System.out.println("the token is " + token.getAccessToken());
			return token.getAccessToken();
			 
		}
		catch(Exception e) {
			log.error("Error in getting token - Error: " + e);
			throw new ResponseStatusException(
				HttpStatus.INTERNAL_SERVER_ERROR,
				"Exception while calling " + url
				);
		}
	}
}
