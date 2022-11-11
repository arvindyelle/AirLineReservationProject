package com.airreservation.demo.controller;

//import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airreservation.demo.model.Flight;
import com.airreservation.demo.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	FlightService service;

	@PostMapping("/addFlight") // http://localhost:3345/flight/addFlight
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String addFlight(@Valid @RequestBody Flight flight) {
		return service.addFlight(flight);
	}

	@DeleteMapping("/deleteFlight/{flightNum}") // http://localhost:3345/flight/deleteFlight/123
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String deleteFlight(@PathVariable(name = "flightNum") int flightNum) {
		return service.deleteFlight(flightNum);
	}

	@GetMapping("/getallflights") // http://localhost:3345/flight/getallflights
	//@PreAuthorize("hasRole('ROLE_ADMIN')"+"||hasRole('ROLE_USER'") 
	
	public List<Flight> viewFlights() {
		return service.viewFlights();

	}

	@GetMapping("/searchflights/{toAdd}/{fromAdd}") // http://localhost:3345/flight/searchflights/
	@PreAuthorize("hasRole('ROLE_USER')")
	public List<Flight> searchflights(@PathVariable(name = "toAdd") String toAdd,
			@PathVariable(name = "fromAdd") String fromAdd/* ,@PathVariable(name="depart") LocalDateTime depart */) {
		return service.searchFlight(toAdd, fromAdd/* , depart */);

	}

	@GetMapping("/getFlightByFlightNum/{flightNum}") // http://localhost:3345/flight/getFlightByFlightNum/123
	@PreAuthorize("hasRole('ROLE_USER')")
	public Flight getFlightByFlightNum(@PathVariable(name = "flightNum") int flightNum) {
		return service.getFlightByFlightNum(flightNum);
	}

}
