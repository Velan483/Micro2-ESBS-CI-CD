package com.velan.reg.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.velan.reg.model.Payment;

@Repository
public interface PaymentRepo {

	public void add(Payment payment);
	public List<Payment> findAllPayments();
	public void delete(int id);
	public List<Payment> findByExhibitorName(String name);
	public List<Payment> findByOrganizerName(String name);
}