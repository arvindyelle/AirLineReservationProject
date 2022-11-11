package com.airreservation.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airreservation.demo.dao.ReservationDao;
import com.airreservation.demo.model.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	ReservationDao dao;

	@Override
	public String ticketBooking(Reservation reservation) {

		return dao.ticketBooking(reservation);
	}

	@Override
	public String cancelBooking(int r_id) {
		

		return dao.cancelBooking(r_id);
	}

}
