
package com.airreservation.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "seat_tbl", uniqueConstraints = { @UniqueConstraint(columnNames = { "seat_number" })

})
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "seat_id")
	private int seatId;
	
	@Column(name = "seat_number")
	private String seatNumber;

	

	public Seat(int seatId, String seatNumber) {
		super();
		this.seatId = seatId;
		this.seatNumber = seatNumber;
	}



	public int getSeatId() {
		return seatId;
	}



	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}



	public String getSeatNumber() {
		return seatNumber;
	}



	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}



	public Seat() {
		// TODO Auto-generated constructor stub
	}

}
