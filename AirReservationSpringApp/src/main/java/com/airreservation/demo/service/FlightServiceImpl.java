package com.airreservation.demo.service;

//import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airreservation.demo.dao.FlightDao;
import com.airreservation.demo.exceptions.FlightNumNotFound;
import com.airreservation.demo.exceptions.FlightsNotFound;
import com.airreservation.demo.model.Flight;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	FlightDao dao;

	@Override
	public String addFlight(Flight flight) {

		return dao.addFlight(flight);
	}

	@Override
	public String deleteFlight(int flightNum) {

		return dao.deleteFlight(flightNum);
	}

	@Override
	public List<Flight> viewFlights() {

		return dao.viewFlights();
	}

	@Override
	public List<Flight> searchFlight(String toAdd, String fromAdd /* , LocalDateTime depart */) {

		List<Flight> flightSearch = dao.searchFlight(toAdd, fromAdd/* , depart */);
		System.out.println(flightSearch);
		if (!flightSearch.isEmpty())
			
			return flightSearch;
		else
			throw new FlightsNotFound("Flights not found");
	}

	@Override
	public Flight getFlightByFlightNum(int flightNum) {

		Flight flight = dao.getFlightByFlightNum(flightNum);
		if (flight != null)
			return flight;
		else
			throw new FlightNumNotFound("Flight number is invalid");
	}

}
