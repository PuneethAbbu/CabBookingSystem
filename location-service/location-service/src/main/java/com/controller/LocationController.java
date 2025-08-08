package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Location;
import com.service.LocationService;
import com.service.RouteService;

@RestController
@RequestMapping(value = "locations")
public class LocationController {
	@Autowired
	RouteService routeService;
	
	@Autowired
	LocationService locationService;
	
    @PostMapping("/distance")
    public ResponseEntity<Integer> calculateDistance(@RequestBody DistanceRequest request) {
        return routeService.getDistance(request.getFromId(), request.getToId())
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Location> getAllLocations() {
    	return locationService.getAllLocations();
    }
    
    public static class DistanceRequest {
        private int fromId;
        private int toId;

        public int getFromId() { return fromId; }
        public int getToId() { return toId; }
        public void setFromId(int fromId) { this.fromId = fromId; }
        public void setToId(int toId) { this.toId = toId; }
    }
}
