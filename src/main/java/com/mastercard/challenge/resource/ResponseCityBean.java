package com.mastercard.challenge.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseCityBean {

	private String origin;
	private String destination;
	private String connected;
	
	public ResponseCityBean() {
		super();
	}
	
	public ResponseCityBean(String origin, String destination, String connected) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.connected = connected;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getConnected() {
		return connected;
	}
	public void setConnected(String connected) {
		this.connected = connected;
	}
}
