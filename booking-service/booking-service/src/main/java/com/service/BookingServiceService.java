package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dto.CabType;
import com.dto.Location;

@Service
public class BookingServiceService {
	@Autowired
	RestTemplate restTemplate;
	
    public List<CabType> fetchAllCabTypes() {
        String url = "http://CAB-SERVICE/cabTypes";
        
        // Using ParameterizedTypeReference for List<CabType>
        ResponseEntity<List<CabType>> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<CabType>>() {}
        );
        
        return response.getBody();
    }
    
    public List<Location> fetchAllLocations() {
    	String url = "http://LOCATION-SERVICE/locations";
    	
    	// Using ParameterizedTypeReference for List<CabType>
    	ResponseEntity<List<Location>> response = restTemplate.exchange(
    			url,
    			HttpMethod.GET,
    			null,
    			new ParameterizedTypeReference<List<Location>>() {}
    			);
    	
    	return response.getBody();
    }
    
    public double getDistance(int fromId, int toId) {
        Map<String, Integer> requestBody = Map.of("fromId", fromId, "toId", toId);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        // 3. Create the HTTP entity
        HttpEntity<Map<String, Integer>> requestEntity = new HttpEntity<>(requestBody, headers);
        
        // 5. Make the POST request
        ResponseEntity<Double> response = restTemplate.postForEntity(
            "http://LOCATION-SERVICE/locations/distance",
            requestEntity,
            Double.class	//Expecting Double response
        );
        
        return response.getBody();
    }
    
    public double getMultiplier(int cabTypeId) {
    	String url = "http://CAB-SERVICE/cabTypes/multiplier/"+cabTypeId;
    	return restTemplate.getForObject(url, Double.class);
    }
    
    public double getFareAmount(double distanceKm, double cabTypeMultiplier) {
        Map<String, Double> requestBody = Map.of("distanceKm", distanceKm, "cabTypeMultiplier", cabTypeMultiplier);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        // 3. Create the HTTP entity
        HttpEntity<Map<String, Double>> requestEntity = new HttpEntity<>(requestBody, headers);
        
        // 5. Make the POST request
        ResponseEntity<Double> response = restTemplate.postForEntity(
            "http://FARE-SERVICE/fareService/calculate",
            requestEntity,
            Double.class	//Expecting Double response
        );
        
        return response.getBody();
    }
}
