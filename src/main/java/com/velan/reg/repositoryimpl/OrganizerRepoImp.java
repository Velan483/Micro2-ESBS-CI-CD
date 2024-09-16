package com.velan.reg.repositoryimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import com.velan.reg.model.Organizer;
import com.velan.reg.repository.OrganizerRepo;

@Repository
@Transactional
public class OrganizerRepoImp implements OrganizerRepo {

	@Autowired
	EntityManager em;

	@Override
	public void add(Organizer organizer) {
		em.persist(organizer);
	}

    @Override
    public Organizer findByEmail(String email) {
        try {
            String hql = "select u from Organizer u WHERE u.email = :email";
            Query query = em.createQuery(hql).setParameter("email", email);
            return (Organizer) query.getSingleResult();
        } catch (Exception e) {
            return null; 
        }
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Organizer> findAllOrganizers() {
		String hql = "from Organizer";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Organizer findById(int id) {
		return em.find(Organizer.class, id);
	}

	@Override
	public void update(Organizer organizer) {
		em.merge(organizer);
	}

	@Override
	public void delete(int id) {
		Organizer organizer = em.find(Organizer.class, id);
		em.remove(organizer);
	}

}
