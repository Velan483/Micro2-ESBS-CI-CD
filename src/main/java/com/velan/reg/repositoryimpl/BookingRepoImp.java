package com.velan.reg.repositoryimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import com.velan.reg.model.Booking;
import com.velan.reg.repository.BookingRepo;

@Repository
@Transactional
public class BookingRepoImp implements BookingRepo {

	@Autowired
	EntityManager em;

	@Override
	public void add(Booking booking) {
		em.persist(booking);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> findAllBookings() {
		String hql = "from Booking";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Booking findById(int id) {
		return em.find(Booking.class, id);
	}

	@Override
	public void update(Booking booking) {
		em.merge(booking);
	}

	@Override
	public void delete(int id) {
		Booking booking = em.find(Booking.class, id);
		em.remove(booking);
	}
	
	@Override
	public List<Booking> findByOrganizerName(String organizerName) {
	    String jpql = "select i from Booking i where i.organizerName = :organizerName";
	    TypedQuery<Booking> query = em.createQuery(jpql, Booking.class);
	    query.setParameter("organizerName", organizerName);
	    return query.getResultList();
	}
	
	@Override
	public List<Booking> findByExhibitorName(String exhibitorName) {
	    String jpql = "select i from Booking i where i.name = :name";
	    TypedQuery<Booking> query = em.createQuery(jpql, Booking.class);
	    query.setParameter("name", exhibitorName);
	    return query.getResultList();
	}

}
