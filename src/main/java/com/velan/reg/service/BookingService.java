package com.velan.reg.service;

import java.util.List;
import com.velan.reg.model.Booking;

public interface BookingService {

	public void addBooking(Booking booking);
	public Booking getBooking(int id);
	public List<Booking> getAllBookings();
	public void updateBooking(Booking booking);
	public void deleteBooking(int id);
	public List<Booking> findByOrganizerName(String name);
	public List<Booking> findByExhibitorName(String name);

}
