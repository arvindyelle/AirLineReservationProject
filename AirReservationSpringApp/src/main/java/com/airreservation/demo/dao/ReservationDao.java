package com.airreservation.demo.dao;

import com.airreservation.demo.model.Reservation;

public interface ReservationDao {

	public String ticketBooking(Reservation reservation);

	public String cancelBooking(int r_id);
	
	public Reservation getBookedRecord(int r_id);

}
