package com.airreservation.demo.exceptions;

public class FlightsNotFound extends RuntimeException{
	public FlightsNotFound(String message) {
		super(message);
	}

}
