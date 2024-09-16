package com.velan.reg.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.velan.reg.model.Booking;
import com.velan.reg.repository.BookingRepo;
import com.velan.reg.service.BookingService;

@Service
public class BookingServiceImp implements BookingService {

	@Autowired
	BookingRepo repo;
	
	@Override
	public void addBooking(Booking booking) {
		repo.add(booking);
	}

	@Override
	public Booking getBooking(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Booking> getAllBookings() {
		return repo.findAllBookings();
	}

	@Override
	public void updateBooking(Booking booking) {
		repo.update(booking);
	}

	@Override
	public void deleteBooking(int id) {
		repo.delete(id);
	}
	
	@Override
    public List<Booking> findByOrganizerName(String name) {
        return repo.findByOrganizerName(name);
    }
	
	@Override
    public List<Booking> findByExhibitorName(String name) {
        return repo.findByExhibitorName(name);
    }
	
}
