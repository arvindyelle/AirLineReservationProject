package com.airreservation.demo.service;

import com.airreservation.demo.model.Seat;

public interface SeatService {
	//public String SelectSeat(Seat seat);
	
	public String createSeats(Seat seat);
	
	public Seat SelectSeat(int seatId);

}
