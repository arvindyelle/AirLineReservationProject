package com.airreservation.demo.exceptions;

public class ReservationIdNotFound extends RuntimeException{
	public ReservationIdNotFound(String message) {
		super(message);
	}

}
