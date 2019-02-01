package com.mastercard.challenge.resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.mastercard.challenge.exception.InternalErrorException;

@Component
public class CityService {
	
	private List<String> roads;
	private List<String> verifiedCities = new ArrayList<>();
	
	
	public boolean isConnected(String origin, String destination) {
		loadCityRoads();
	    return isRoadConnected(origin, destination);
	}

	private void loadCityRoads() {
		File file = new File(getClass().getClassLoader().getResource("city.txt").getFile());
	    try (Stream<String> cityRoads = Files.lines(file.toPath())) {
	    	roads = cityRoads.sorted().collect(Collectors.toList());
		} catch (IOException e) {
			throw new InternalErrorException(e.getMessage());
		}
	}

	private boolean isRoadConnected(String origin, String destination) {
		List<String> originRoads = roads.stream().filter(road -> road.contains(origin))
	    										 .collect(Collectors.toList());
	    
		boolean result = false;
	    for (String road : originRoads) {
			if(road.contains(destination))
				return true;
		}
    	verifiedCities.add(origin);
	    
	    for (String road : originRoads) {
	    	String destCity = road.replace(origin, "").replace(",", "").trim();
			if(verifiedCities.contains(destCity))
				continue;
			
	    	if(isRoadConnected(destCity, destination))
	    		return true;
		}
		
		return result;
	}
}
