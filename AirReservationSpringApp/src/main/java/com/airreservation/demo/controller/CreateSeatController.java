package com.airreservation.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airreservation.demo.model.Seat;
import com.airreservation.demo.service.SeatService;

@RestController
@RequestMapping("/seat")
public class CreateSeatController {
	@Autowired
	SeatService service;

	@PostMapping("/createseat")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String createSeat(@RequestBody Seat seat) {
		return service.createSeats(seat);
	}
	
	
	@GetMapping("selectseat/{seatId}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public Seat selectseat(@PathVariable(name="seatId") int seatId) {
		return service.SelectSeat(seatId);
	}

}
