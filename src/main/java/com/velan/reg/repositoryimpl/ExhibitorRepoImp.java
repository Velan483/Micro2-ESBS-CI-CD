package com.velan.reg.repositoryimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import com.velan.reg.model.Exhibitor;
import com.velan.reg.repository.ExhibitorRepo;

@Repository
@Transactional
public class ExhibitorRepoImp implements ExhibitorRepo {

	@Autowired
	EntityManager em;

	@Override
	public void add(Exhibitor exhibitor) {
		em.persist(exhibitor);
	}

    @Override
    public Exhibitor findByEmail(String email) {
        try {
            String hql = "select u from Exhibitor u WHERE u.email = :email";
            Query query = em.createQuery(hql).setParameter("email", email);
            return (Exhibitor) query.getSingleResult();
        } catch (Exception e) {
            return null; 
        }
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Exhibitor> findAllExhibitors() {
		String hql = "from Exhibitor";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Exhibitor findById(int id) {
		return em.find(Exhibitor.class, id);
	}

	@Override
	public void update(Exhibitor exhibitor) {
		em.merge(exhibitor);
	}

	@Override
	public void delete(int id) {
		Exhibitor exhibitor = em.find(Exhibitor.class, id);
		em.remove(exhibitor);
	}

}
