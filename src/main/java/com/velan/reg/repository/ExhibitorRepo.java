package com.velan.reg.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.velan.reg.model.Exhibitor;

@Repository
public interface ExhibitorRepo {
	
	public void add(Exhibitor exhibitor);
	public List<Exhibitor> findAllExhibitors();
	public Exhibitor findById(int id);
	public void update(Exhibitor exhibitor);
	public void delete(int id);
	public Exhibitor findByEmail(String email);
	
}
