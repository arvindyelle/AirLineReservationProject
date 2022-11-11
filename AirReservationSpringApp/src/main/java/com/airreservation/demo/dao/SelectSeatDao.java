package com.airreservation.demo.dao;

import com.airreservation.demo.model.Seat;

public interface SelectSeatDao {
	
	//public String SelectSeat(Seat seat);
	
	public String createSeats(Seat seat);
	
	public Seat SelectSeat(int seatId);
	


}
