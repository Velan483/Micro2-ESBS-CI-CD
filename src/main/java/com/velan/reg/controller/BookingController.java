package com.velan.reg.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.velan.reg.model.Booking;
import com.velan.reg.serviceimpl.BookingServiceImp;

@RestController
@RequestMapping("/booking")
@CrossOrigin("http://localhost:3000")
public class BookingController {

	@Autowired
	BookingServiceImp service;
	
	static final String SUCCESS="Success";
	static final String FAILURE="Failure";
	
	@PostMapping
	public String insertBooking(@RequestBody Booking booking) {
		String msg = "";
		try {
			service.addBooking(booking);
			msg = SUCCESS;
		}
		catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}


	@GetMapping("{id}")
	public Booking getBookingById(@PathVariable("id") int id) {
		return service.getBooking(id);
	}

	@GetMapping("/all")
	public List<Booking> getBookings() {
		return service.getAllBookings();
	}
	
	@PutMapping()
	public String updateBooking(@RequestBody Booking booking) {
		String msg = "";

		try {
			service.updateBooking(booking);
			msg = SUCCESS;
		}
		catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}
	
	@DeleteMapping("{id}")
	public String deleteBookingById(@PathVariable("id")int id) {
		String msg="";
		try {
			service.deleteBooking(id);
			msg=SUCCESS;
		} 
		catch (Exception e) {
			msg=FAILURE;
		}
		return msg;
	}
	
	@GetMapping("/name/{name}")
    public List<Booking> getBookingByOrganizerName(@PathVariable("name") String name) {
        return service.findByOrganizerName(name);
    }
	
	@GetMapping("/name/exhibitor/{name}")
    public List<Booking> getBookingByExhibitorName(@PathVariable("name") String name) {
        return service.findByExhibitorName(name);
    }
 
}

