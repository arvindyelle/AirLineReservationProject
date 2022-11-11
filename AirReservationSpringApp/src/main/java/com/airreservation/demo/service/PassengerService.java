package com.airreservation.demo.service;

import java.util.List;

import com.airreservation.demo.model.Passenger;

public interface PassengerService {
	public String addPassenger(Passenger passenger);

	public String updatePassenger(Passenger passenger);

	public String deletePassenger(int passengerId);

	public List<Passenger> getallpassengers();

}
