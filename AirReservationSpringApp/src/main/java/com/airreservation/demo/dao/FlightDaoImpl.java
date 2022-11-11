package com.airreservation.demo.dao;

//import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.airreservation.demo.model.Flight;

@Repository
@Transactional
public class FlightDaoImpl implements FlightDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public String addFlight(Flight flight) {
		em.persist(flight);
		return "Flight Added Successfully!";
	}

	@Override
	public String deleteFlight(int flightNum) {
		Flight flight = em.find(Flight.class, flightNum);
		em.remove(flight);
		return "Flight Deleted Successfully!";
	}

	@Override
	public List<Flight> viewFlights() {
		TypedQuery<Flight> query = em.createQuery("select f from Flight f", Flight.class);

		return query.getResultList();

	}

	@Override
	public List<Flight> searchFlight(String toAdd, String fromAdd /* ,LocalDateTime depart */) {
		TypedQuery<Flight> query = em.createQuery("select f from Flight f where f.toAdd=?1 and f.fromAdd=?2 ",
				Flight.class);
		query.setParameter(1, toAdd);
		query.setParameter(2, fromAdd);
		// query.setParameter(3, depart);
		return query.getResultList();
	}

	@Override
	public Flight getFlightByFlightNum(int flightNum) {

		return em.find(Flight.class, flightNum);
	}

}
