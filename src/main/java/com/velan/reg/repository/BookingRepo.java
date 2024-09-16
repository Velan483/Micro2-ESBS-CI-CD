package com.velan.reg.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.velan.reg.model.Booking;

@Repository
public interface BookingRepo {

	public void add(Booking booking);
	public List<Booking> findAllBookings();
	public Booking findById(int id);
	public void update(Booking booking);
	public void delete(int id);
	public List<Booking> findByOrganizerName(String name);
	public List<Booking> findByExhibitorName(String name);
}
