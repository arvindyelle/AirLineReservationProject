package com.airreservation.demo.dao;

//import java.time.LocalDateTime;
import java.util.List;

import com.airreservation.demo.model.Flight;

public interface FlightDao {

	public String addFlight(Flight flight);

	public String deleteFlight(int flightNum);

	public List<Flight> viewFlights();

	public List<Flight> searchFlight(String toAdd, String fromAdd /*, LocalDateTime depart*/);

	public Flight getFlightByFlightNum(int flightNum);

}
