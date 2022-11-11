package com.airreservation.demo.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Payment")
public class Payment {
	@Id
	@GeneratedValue
	@Column(name = "payment_id")
	private int paymentId;

	@Column(name = "cost_per_seat")
	private double costPerSeat;

	@Column(name = "card_holder_name")
	private String cardHolderName;

	@Column(name = "cvv")
	private int cvv;

	@Column(name = "card_number")
	private long cardNumber;

	@Column(name = "expiration_date")
	private LocalDate expirationDate;

	@Column(name = "total_amount")
	private double totalAmount;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getCostPerSeat() {
		return costPerSeat;
	}

	public void setCostPerSeat(double costPerSeat) {
		this.costPerSeat = costPerSeat;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Payment(int paymentId, double costPerSeat, String cardHolderName, int cvv, long cardNumber,
			LocalDate expirationDate, double totalAmount) {
		super();
		this.paymentId = paymentId;
		this.costPerSeat = costPerSeat;
		this.cardHolderName = cardHolderName;
		this.cvv = cvv;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.totalAmount = totalAmount;
	}

	public Payment() {
		// TODO Auto-generated constructor stub
	}

}
