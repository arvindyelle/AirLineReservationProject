
package com.airreservation.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.airreservation.demo.model.Flight;
import com.airreservation.demo.model.Passenger;
import com.airreservation.demo.model.Payment;
//import com.airreservation.demo.model.Flight;
import com.airreservation.demo.model.Reservation;
import com.airreservation.demo.model.Seat;

@Repository

@Transactional
public class ReservationDaoImpl implements ReservationDao {
    @Autowired
    SelectSeatDao seatdao;
    
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	FlightDao flightDao;
	
	@Autowired
	PassengerDao passengerDao;
	
	
	
	@Override
	public String ticketBooking(Reservation reservation) {
		//Flight flight=flightDao.getFlightByFlightNum(reservation.getFlight().getFlightNum());
		//System.out.println(flight);
		Flight flight=flightDao.getFlightByFlightNum(reservation.getFlight().getFlightNum());
		System.out.println(flight);
		reservation.setFlight(flight);
		Passenger passenger = passengerDao.getPassengerById(reservation.getPassenger().getPassengerId());
		reservation.setPassenger(passenger);
		Seat seat=seatdao.SelectSeat(reservation.getSeat().getSeatId());
		reservation.setSeat(seat);
		double amount=reservation.getPayment().getCostPerSeat();
		int noOfSeats=reservation.getNoOfSeats();
		double totalAmount=amount*noOfSeats;
		//reservation.set
		Payment p=new Payment();
		p.setCardHolderName(reservation.getPayment().getCardHolderName());
		p.setCardNumber(reservation.getPayment().getCardNumber());
		p.setCostPerSeat(reservation.getPayment().getCostPerSeat());
		p.setCvv(reservation.getPayment().getCvv());
		p.setExpirationDate(reservation.getPayment().getExpirationDate());
		p.setTotalAmount(totalAmount);
		reservation.setPayment(p);
		em.persist(reservation);
		return "Reserved Successfully";
	}

	@Override
	public String cancelBooking(int r_id) {
		Reservation reservation = em.find(Reservation.class, r_id);
		em.remove(reservation);
		return "cancelled successfully";
	}

	@Override
	public Reservation getBookedRecord(int r_id) {
		
		return em.find(Reservation.class, r_id);
	}

}
