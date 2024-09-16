package com.velan.reg.repositoryimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import com.velan.reg.model.Payment;
import com.velan.reg.repository.PaymentRepo;

@Repository
@Transactional
public class PaymentRepoImp implements PaymentRepo {

	@Autowired
	EntityManager em;

	@Override
	public void add(Payment payment) {
		em.persist(payment);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> findAllPayments() {
		String hql = "from Payment";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public void delete(int id) {
		Payment payment = em.find(Payment.class, id);
		em.remove(payment);
	}
	
	
	@Override
	public List<Payment> findByExhibitorName(String exhibitorName) {
	    String jpql = "select i from Payment i join i.booking vr where vr.name = :name";
	    TypedQuery<Payment> query = em.createQuery(jpql, Payment.class);
	    query.setParameter("name", exhibitorName);
	    return query.getResultList();
	}
	
	@Override
	public List<Payment> findByOrganizerName(String organizerName) {
	    String jpql = "select i from Payment i join i.booking vr where vr.organizerName = :organizerName";
	    TypedQuery<Payment> query = em.createQuery(jpql, Payment.class);
	    query.setParameter("organizerName", organizerName);
	    return query.getResultList();
	}
	

}
