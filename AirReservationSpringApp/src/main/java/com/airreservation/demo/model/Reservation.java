
package com.airreservation.demo.model;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
//import javax.validation.constraints.Min;

@Entity

@Table(name = "reservation_tb")
public class Reservation {

	@Id

	@Column(name = "id")
	private int r_id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
	@Column(name = "date")
	private LocalDateTime date;

	@Column(name = "no_of_seats")
	// @Min(value=1,message="Select atleast 1 seat")
	private int noOfSeats;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "flightNum")
	private Flight flight;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "passengerId")
	private Passenger passenger;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "seatId")
	private Seat seat;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "paymentId")
	private Payment payment;

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Reservation(int r_id, LocalDateTime date, int noOfSeats, Flight flight, Passenger passenger, Seat seat,
			Payment payment) {
		super();
		this.r_id = r_id;
		this.date = date;
		this.noOfSeats = noOfSeats;
		this.flight = flight;
		this.passenger = passenger;
		this.seat = seat;
		this.payment = payment;
	}

	public Reservation() {
		// TODO Auto-generated constructor stub
	}
}
