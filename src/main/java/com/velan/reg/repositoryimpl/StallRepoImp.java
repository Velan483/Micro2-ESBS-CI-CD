package com.velan.reg.repositoryimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import com.velan.reg.model.Stall;
import com.velan.reg.repository.StallRepo;

@Repository
@Transactional
public class StallRepoImp implements StallRepo {

	@Autowired
	EntityManager em;

	@Override
	public void add(Stall stall) {
		em.persist(stall);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Stall> findAllStalls() {
		String hql = "from Stall";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Stall findById(int id) {
		return em.find(Stall.class, id);
	}

	@Override
	public void update(Stall stall) {
		em.merge(stall);
	}

	@Override
	public void delete(int id) {
		Stall stall = em.find(Stall.class, id);
		em.remove(stall);
	}
	
	@Override
	public List<Stall> findByOrganizerName(String organizerName) {
	    String jpql = "select i from Stall i join i.exhibition vr where vr.organizerName = :organizerName";
	    TypedQuery<Stall> query = em.createQuery(jpql, Stall.class);
	    query.setParameter("organizerName", organizerName);
	    return query.getResultList();
	}
	
	@Override
	public List<Stall> findByEventVenue(String eventVenue) {
	    String jpql = "select i from Stall i join i.exhibition vr where vr.eventVenue = :eventVenue";
	    TypedQuery<Stall> query = em.createQuery(jpql, Stall.class);
	    query.setParameter("eventVenue", eventVenue);
	    return query.getResultList();
	}
	
	@Override
	public Stall findByEventName(String eventName) {
	    String jpql = "select i from Stall i join i.exhibition vr where vr.eventName = :eventName";
	    TypedQuery<Stall> query = em.createQuery(jpql, Stall.class);
	    query.setParameter("eventName", eventName);
	    return query.getSingleResult();
	}

}
