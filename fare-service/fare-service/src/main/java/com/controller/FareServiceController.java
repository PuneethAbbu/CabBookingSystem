package com.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@RequestMapping(value = "fareService")
public class FareServiceController {
	private static final double DEFAULT_BASE_RATE = 1.0;
	
	@PostMapping("/calculate")
    public double calculateFare( @RequestBody FareCalculationRequest request) {
        double baseRate = request.getBaseRatePerKm() != null ? 
                         request.getBaseRatePerKm() : DEFAULT_BASE_RATE;
        
        return request.getDistanceKm() * baseRate * request.getCabTypeMultiplier();
    }

    @Data
    private static class FareCalculationRequest {
        private double distanceKm;
        private double cabTypeMultiplier;
        private Double baseRatePerKm;
    }
}
