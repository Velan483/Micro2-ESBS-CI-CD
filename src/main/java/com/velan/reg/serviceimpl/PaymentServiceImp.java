package com.velan.reg.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.velan.reg.model.Payment;
import com.velan.reg.repository.PaymentRepo;
import com.velan.reg.service.PaymentService;

@Service
public class PaymentServiceImp implements PaymentService {

	@Autowired
	PaymentRepo repo;
	
	@Override
	public void addPayment(Payment payment) {
		repo.add(payment);
	}

	@Override
	public List<Payment> getAllPayments() {
		return repo.findAllPayments();
	}

	@Override
	public void deleteBooking(int id) {
		repo.delete(id);
	}
	
	@Override
    public List<Payment> findByExhibitorName(String name) {
        return repo.findByExhibitorName(name);
    }
	
	@Override
    public List<Payment> findByOrganizerName(String name) {
        return repo.findByOrganizerName(name);
    }
	
}
