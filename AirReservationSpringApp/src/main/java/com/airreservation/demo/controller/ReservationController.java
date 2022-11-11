package com.airreservation.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airreservation.demo.model.Reservation;
import com.airreservation.demo.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	ReservationService service;

	@PostMapping("/ticketBooking") // http://localhost:3345/reservation/ticketBooking
	@PreAuthorize("hasRole('ROLE_USER')")
	public String ticketBooking(@Valid @RequestBody Reservation reservation) {
		return service.ticketBooking(reservation);

	}

	@DeleteMapping("/cancelTicket/{r_id}") // http://localhost:3345/reservation/cancelTicket/123
	@PreAuthorize("hasRole('ROLE_USER')")
	public String cancelBooking(@PathVariable(name = "r_id") int r_id) {
		return service.cancelBooking(r_id);
	}

}
