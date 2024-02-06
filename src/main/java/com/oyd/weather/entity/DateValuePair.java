package com.oyd.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DateValuePair {
	
	@JsonProperty("date")
	private String date;
	
	@JsonProperty("value")
	private String value;
	
	public DateValuePair() {
		
	}
	
	public DateValuePair(String date, String value) {
		super();
		this.date = date;
		this.value = value;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}	
}
