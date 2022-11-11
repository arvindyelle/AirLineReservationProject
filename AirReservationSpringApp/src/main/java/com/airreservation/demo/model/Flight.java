package com.airreservation.demo.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "flight_tbl")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="flight_num")
	private int flightNum;

	@Column(name="to_add")
	private String toAdd;

	@Column(name="from_add")
	private String fromAdd;

	@Column(name="depart")
	private LocalDateTime depart;
    
	@Column(name="arrive")
	private LocalDateTime arrive;

	@Column(name="duration")
	private int duration;

	@Column(name="cabin")
	private String cabin;
	@Column(name="seat_capacity")
	private int seatcapacity;

	
	  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	  
	  @JoinTable(name = "passenger_flight", inverseJoinColumns = {
	  
	  @JoinColumn(name = "flight_num") },
	  joinColumns = {
	  
	  @JoinColumn(name = "passenger_id") })
	  private Set<Passenger> passenger;


	public int getFlightNum() {
		return flightNum;
	}


	public void setFlightNum(int flightNum) {
		this.flightNum = flightNum;
	}


	public String getToAdd() {
		return toAdd;
	}


	public void setToAdd(String toAdd) {
		this.toAdd = toAdd;
	}


	public String getFromAdd() {
		return fromAdd;
	}


	public void setFromAdd(String fromAdd) {
		this.fromAdd = fromAdd;
	}


	public LocalDateTime getDepart() {
		return depart;
	}


	public void setDepart(LocalDateTime depart) {
		this.depart = depart;
	}


	public LocalDateTime getArrive() {
		return arrive;
	}


	public void setArrive(LocalDateTime arrive) {
		this.arrive = arrive;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public String getCabin() {
		return cabin;
	}


	public void setCabin(String cabin) {
		this.cabin = cabin;
	}


	public int getSeatcapacity() {
		return seatcapacity;
	}


	public void setSeatcapacity(int seatcapacity) {
		this.seatcapacity = seatcapacity;
	}


	public Set<Passenger> getPassenger() {
		return passenger;
	}


	public void setPassenger(Set<Passenger> passenger) {
		this.passenger = passenger;
	}


	public Flight(int flightNum, String toAdd, String fromAdd, LocalDateTime depart, LocalDateTime arrive, int duration,
			String cabin, int seatcapacity, Set<Passenger> passenger) {
		super();
		this.flightNum = flightNum;
		this.toAdd = toAdd;
		this.fromAdd = fromAdd;
		this.depart = depart;
		this.arrive = arrive;
		this.duration = duration;
		this.cabin = cabin;
		this.seatcapacity = seatcapacity;
		this.passenger = passenger;
	}
	  
	 
	public Flight() {
		// TODO Auto-generated constructor stub
	}
}
