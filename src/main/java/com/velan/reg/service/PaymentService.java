package com.velan.reg.service;

import java.util.List;
import com.velan.reg.model.Payment;

public interface PaymentService {

	public void addPayment(Payment payment);
	public List<Payment> getAllPayments();
	public void deleteBooking(int id);
	public List<Payment> findByExhibitorName(String name);
	public List<Payment> findByOrganizerName(String name);

}
