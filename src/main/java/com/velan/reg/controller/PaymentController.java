package com.velan.reg.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.velan.reg.model.EmailRequest;
import com.velan.reg.model.Payment;
import com.velan.reg.serviceimpl.PaymentServiceImp;
import com.velan.reg.service.EmailService;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/payment")
@CrossOrigin("http://localhost:3000")
public class PaymentController {

	@Autowired
	PaymentServiceImp service;
	
	static final String SUCCESS="Success";
	static final String FAILURE="Failure";
	
	@PostMapping
	public String insertPayment(@RequestBody Payment payment) {
		String msg = "";
		try {
			service.addPayment(payment);
			msg = SUCCESS;
		}
		catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}
	
	@GetMapping("/all")
	public List<Payment> getPayments() {
		return service.getAllPayments();
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
    public List<Payment> getPaymentByExhibitorName(@PathVariable("name") String name) {
        return service.findByExhibitorName(name);
    }
	
	@GetMapping("/name/organizer/{name}")
    public List<Payment> getPaymentByOrganizerName(@PathVariable("name") String name) {
        return service.findByOrganizerName(name);
    }
 
	@Autowired
    private EmailService emailService;
	
	@PostMapping("/send")
	public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
	    try {
	        emailService.sendEmail(emailRequest.getFrom(), emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getBody(), emailRequest.getAttachment());
	        return ResponseEntity.ok("Email sent successfully");
	    } catch (MessagingException | IOException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email: " + e.getMessage());
	    }
	}

	
}

