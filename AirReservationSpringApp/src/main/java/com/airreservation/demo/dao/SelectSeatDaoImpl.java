package com.airreservation.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.airreservation.demo.model.Seat;

@Repository
@Transactional
public class SelectSeatDaoImpl implements SelectSeatDao {
    @PersistenceContext
    EntityManager em;
	/*@Override
	public String SelectSeat(Seat seat) {
		em.persist(seat);
		return "Seat selected successfully";
	}
*/

	@Override
	public String createSeats(Seat seat) {
		em.persist(seat);
		return "Seat created successfully";
	}
	@Override
	public Seat SelectSeat(int seatId) {
		
		return em.find(Seat.class, seatId);
	}

	
}
