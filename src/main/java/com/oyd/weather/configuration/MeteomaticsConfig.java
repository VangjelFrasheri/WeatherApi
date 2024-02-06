package com.oyd.weather.configuration;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.oyd.weather.util.DateUtil;

@Component
@ConfigurationProperties
public class MeteomaticsConfig {

	@Value("${meteomaticsBaseUrlSufix}")
	private String meteomaticsBaseUrlSufix;
	
	@Value("${meteomaticsPassword}")
	private String password;
	
	@Value("${apiUsername}")
	private String apiUsername;
	
	public String getMeteomaticsBaseUrlSufix() {
		return meteomaticsBaseUrlSufix;
	}


	public void setMeteomaticsBaseUrlSufix(String meteomaticsBaseUrlSufix) {
		this.meteomaticsBaseUrlSufix = meteomaticsBaseUrlSufix;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApiUsername() {
		return apiUsername;
	}


	public void setApiUsername(String apiUsername) {
		this.apiUsername = apiUsername;
	}


	public String getWeatherNowUrl() {
		String date = DateUtil.getCurrentDateInMeteoFormat();
		//String url = "https://na_frasheri_vangjel:2YpMcQo97e@api.meteomatics.com/2024-01-24T01:43:07Z/t_2m:F,precip_24h:mm/42.3876,-71.0995/json";
		//"https://api.meteomatics.com/2024-01-23T03:43:07Z/t_2m:F,precip_24h:mm/42.3876,-71.0995/json";
		String url = "https://" + meteomaticsBaseUrlSufix + date + "Z/t_2m:F,precip_24h:mm/42.3876,-71.0995/json";
		return url;
	}
	
	public String getDateRangeUrl(int numbOfDays) {
		String dateRange = DateUtil.getDateRangeInMeteoFormat(numbOfDays);
		String url = "https://" + meteomaticsBaseUrlSufix + dateRange + ":PT24H/t_2m:F,precip_24h:mm/42.3876,-71.0995/json";
		return url;
	}
	
	public String getUserAndPassword() {
		 //apiUsername + ":" + password;
		 return Base64.getEncoder().encodeToString((apiUsername + ":" + password).getBytes());
	}
}
