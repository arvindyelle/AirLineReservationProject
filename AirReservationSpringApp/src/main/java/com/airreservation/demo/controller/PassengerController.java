package com.airreservation.demo.controller;

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

import com.airreservation.demo.model.Passenger;
import com.airreservation.demo.service.PassengerService;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
	@Autowired
	PassengerService service;

	@PostMapping("/addPassenger") // http://localhost:3345/flight/addFlight
	@PreAuthorize("hasRole('ROLE_USER')")
	public String addPassenger(@Valid @RequestBody Passenger passenger) {
		return service.addPassenger(passenger);
	}

	@PostMapping("/updatePassenger") // http://localhost:3345/flight/addFlight
	@PreAuthorize("hasRole('ROLE_USER')")
	public String updatePassenger(@RequestBody Passenger passenger) {
		return service.updatePassenger(passenger);
	}

	@DeleteMapping("/deletePassenger/{passengerId}") // http://localhost:3345/flight/deleteFlight/123
	@PreAuthorize("hasRole('ROLE_USER')")
	public String deletePassenger(@PathVariable(name = "passengerId") int passengerId) {
		return service.deletePassenger(passengerId);
	}

	@GetMapping("/getallpassengers") // http://localhost:3345/passenger/getallpassengers
	@PreAuthorize("hasRole('ROLE_USER')")
	public List<Passenger> getallpassengers() {
		return service.getallpassengers();
	}

}
