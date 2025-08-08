package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.BookingRequest;
import com.dto.CabType;
import com.dto.Location;
import com.service.BookingServiceService;

@Controller
@RequestMapping(value = "cabBooking")
public class BookingServiceController {
	@Autowired
	BookingServiceService bookingService;
	
	@GetMapping(value = "")
	public String openPage(Model model) {
		List<CabType> cabTypes = bookingService.fetchAllCabTypes();
		List<Location> locations = bookingService.fetchAllLocations();
		model.addAttribute("cabTypes", cabTypes);
		model.addAttribute("locations", locations);
		model.addAttribute("booking", new BookingRequest());
		return "booking";
	}
	
	@PostMapping(value = "confirmation")
	public String confirmation(Model model, BookingRequest bookingRequest) {
		double distance = bookingService.getDistance(bookingRequest.getFromId(), bookingRequest.getToId());
		double multiplier = bookingService.getMultiplier(bookingRequest.getCabTypeId());
		double fareAmount = bookingService.getFareAmount(distance, multiplier);
		model.addAttribute("fareAmount", fareAmount);
		return "bookingConfirmation";
	}
	
	@PostMapping(value = "success")
	public String success() {
		return "success";
	}
}
