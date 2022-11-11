package com.airreservation.demo.exceptions;

public class FlightNumNotFound extends RuntimeException {
	public FlightNumNotFound(String message) {
		super(message);
	}
}
