package com.airreservation.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;

@Entity
@Table(name = "passenger_tb")
public class Passenger {
	@Id
	@GeneratedValue
	@Column(name = "passenger_id")
	private int passengerId;
	@Column(name = "passenger_name")
	// @NotNull
	private String passengerName;

	@Column(name = "age")
	// @Min(value = 5, message = "Age should be atleast 5 above")
	private int age;
	@Column(name = "lugagge")
	private double luggage;

	@Column(name = "aadhar_number")

	private long aadharNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;
	@Column(name = "gender")
	private String gender;
	/*
	 * @ManyToMany(fetch=FetchType.LAZY,mappedBy = "passenger_tb") private
	 * Set<Flight> flights;
	 */

	/*
	 * @OneToMany(fetch=FetchType.LAZY,mappedBy = "passenger_tb") private
	 * Set<Reservation> reservations;
	 */

	public String getPassengerName() {
		return passengerName;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getLuggage() {
		return luggage;
	}

	public void setLuggage(double luggage) {
		this.luggage = luggage;
	}

	public long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/*
	 * public Set<Flight> getFlights() { return flights; }
	 * 
	 * public void setFlights(Set<Flight> flights) { this.flights = flights; }
	 */

	/*
	 * public Set<Reservation> getReservations() { return reservations; }
	 * 
	 * public void setReservations(Set<Reservation> reservations) {
	 * this.reservations = reservations; }
	 */

	public Passenger(int passengerId, String passengerName, int age, double luggage, long aadharNumber, String email,
			String phone, String gender) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.age = age;
		this.luggage = luggage;
		this.aadharNumber = aadharNumber;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		// this.flights = flights;
		// this.reservations = reservations;
	}

	public Passenger() {
		// TODO Auto-generated constructor stub
	}
}
