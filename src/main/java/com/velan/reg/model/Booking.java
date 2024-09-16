package com.velan.reg.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @Column
    private String eventName;

    @Column
    private String organizerName;
    
    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @Column
    private int numberOfStalls;

    @Column
    private double amount;

    @Column
    private String bookingDate;

    @Enumerated(EnumType.STRING)
    @Column
    private BookingStatus status;
    
	public Booking() {
		super();
	}
	
	public Booking(int bookingId, String eventName, String organizerName, String name, String email, String phoneNumber,
			int numberOfStalls, double amount, String bookingDate, BookingStatus status) {
		super();
		this.bookingId = bookingId;
		this.eventName = eventName;
		this.organizerName = organizerName;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.numberOfStalls = numberOfStalls;
		this.amount = amount;
		this.bookingDate = bookingDate;
		this.status = status;
	}

	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getNumberOfStalls() {
		return numberOfStalls;
	}

	public void setNumberOfStalls(int numberOfStalls) {
		this.numberOfStalls = numberOfStalls;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public String getOrganizerName() {
		return organizerName;
	}

	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", eventName=" + eventName + ", organizerName=" + organizerName
				+ ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", numberOfStalls="
				+ numberOfStalls + ", amount=" + amount + ", bookingDate=" + bookingDate + ", status=" + status + "]";
	}

}

