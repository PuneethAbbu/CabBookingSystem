package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.RouteReposiroty;

@Service
public class RouteService {
	@Autowired
	RouteReposiroty locationRespository;
	
	public Optional<Integer> getDistance(int fromId, int toId) {
        return locationRespository.findDistance(fromId, toId);
    }
}
