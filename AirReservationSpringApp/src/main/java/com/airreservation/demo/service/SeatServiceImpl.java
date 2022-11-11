package com.airreservation.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airreservation.demo.dao.SelectSeatDao;
import com.airreservation.demo.model.Seat;

@Service
public class SeatServiceImpl implements SeatService{
    @Autowired
    SelectSeatDao dao;
	/*
	 * @Override public String SelectSeat(Seat seat) {
	 * 
	 * return dao.SelectSeat(seat); }
	 */

	@Override
	public String createSeats(Seat seat) {
		
		return dao.createSeats(seat);
	}

	@Override
	public Seat SelectSeat(int seatId) {
		
		return dao.SelectSeat(seatId);
	}

}
