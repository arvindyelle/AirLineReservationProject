package com.airreservation.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airreservation.demo.dao.PassengerDao;
import com.airreservation.demo.model.Passenger;
@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    PassengerDao dao;
	@Override
	public String addPassenger(Passenger passenger) {
		
		return dao.addPassenger(passenger);
	}

	@Override
	public String updatePassenger(Passenger passenger) {
		
		return dao.updatePassenger(passenger);
	}

	@Override
	public String deletePassenger(int passengerId) {
		
		return dao.deletePassenger(passengerId);
	}

	@Override
	public List<Passenger> getallpassengers() {
		
		return dao.getallpassengers();
	}

}
