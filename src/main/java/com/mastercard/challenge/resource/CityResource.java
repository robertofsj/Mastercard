package com.mastercard.challenge.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityResource {
	
	@Autowired
	private CityService service;
	
	@GetMapping("/connected")
	public ResponseCityBean isConnected(@RequestParam("origin") String origin, 
										@RequestParam("destination") String destination) {
		boolean connected = service.isConnected(origin, destination);
		return new ResponseCityBean(origin, destination, connected?"Yes":"No");
	}
}
