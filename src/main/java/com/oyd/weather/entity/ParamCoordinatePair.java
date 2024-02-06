package com.oyd.weather.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParamCoordinatePair {

	@JsonProperty("parameter")
	private String paramater;
	
	@JsonProperty("coordinates")
	private List<Coordinate> coordinates;

	public String getParamater() {
		return paramater;
	}

	public void setParamater(String paramater) {
		this.paramater = paramater;
	}

	public List<Coordinate> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Coordinate> coordinates) {
		this.coordinates = coordinates;
	}

	
}
