package com.airreservation.demo.dao;

import java.util.List;

import com.airreservation.demo.model.Passenger;

public interface PassengerDao {
	
	public String addPassenger(Passenger passenger);
	

	public String updatePassenger(Passenger passenger);
	
	public String deletePassenger(int passengerId);
	
	public List<Passenger> getallpassengers();


	public Passenger getPassengerById(int passengerId);

}
