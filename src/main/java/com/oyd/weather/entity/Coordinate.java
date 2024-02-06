package com.oyd.weather.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordinate {

	@JsonProperty("lat")
	private String latitude;
	
	@JsonProperty("lon")
	private String longitude;
	
	@JsonProperty("dates")
	private List<DateValuePair> dates;
	
	public Coordinate() {
		
	}

	public Coordinate(String latitude, String longitude, List<DateValuePair> dates) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.dates = dates;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public List<DateValuePair> getDates() {
		return dates;
	}

	public void setDates(List<DateValuePair> dates) {
		this.dates = dates;
	}
	
}
