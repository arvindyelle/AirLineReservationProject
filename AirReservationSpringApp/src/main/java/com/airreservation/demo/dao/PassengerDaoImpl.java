package com.airreservation.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.airreservation.demo.model.Passenger;
@Repository
@Transactional
public class PassengerDaoImpl implements PassengerDao {
    @PersistenceContext
    EntityManager em;
	@Override
	public String addPassenger(Passenger passenger) {
		em.persist(passenger);
		return "Passenger added successfully";
	}

	@Override
	public String updatePassenger(Passenger passenger) {
		em.merge(passenger);
		return "Passenger updated successfully";
	}

	@Override
	public String deletePassenger(int passengerId) {
		Passenger passenger=em.find(Passenger.class, passengerId);
		em.remove(passenger);
		return "Passenger deleted successfully";
	}

	@Override
	public List<Passenger>getallpassengers() {
		TypedQuery<Passenger> query = em.createQuery("select p from Passenger p", Passenger.class);
		return query.getResultList();
		
	}

	@Override
	public Passenger getPassengerById(int passengerId) {
		
		return em.find(Passenger.class, passengerId);
	}

}
