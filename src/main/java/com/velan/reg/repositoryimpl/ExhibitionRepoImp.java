package com.velan.reg.repositoryimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import com.velan.reg.model.Exhibition;
import com.velan.reg.repository.ExhibitionRepo;

@Repository
@Transactional
public class ExhibitionRepoImp implements ExhibitionRepo {

	@Autowired
	EntityManager em;

	@Override
	public void add(Exhibition exhibition) {
		em.persist(exhibition);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Exhibition> findAllExhibitions() {
		String hql = "from Exhibition";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Exhibition findById(int id) {
		return em.find(Exhibition.class, id);
	}

	@Override
	public void update(Exhibition exhibition) {
		em.merge(exhibition);
	}

	@Override
	public void delete(int id) {
		Exhibition exhibition = em.find(Exhibition.class, id);
		em.remove(exhibition);
	}

}
