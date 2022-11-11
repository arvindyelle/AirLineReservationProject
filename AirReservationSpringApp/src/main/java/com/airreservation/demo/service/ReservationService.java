package com.airreservation.demo.service;

import com.airreservation.demo.model.Reservation;

public interface ReservationService {

	public String ticketBooking(Reservation reservation);

	public String cancelBooking(int r_id);

}
