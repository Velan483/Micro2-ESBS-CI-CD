package com.velan.reg.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.velan.reg.model.Organizer;

@Repository
public interface OrganizerRepo {
	
	public void add(Organizer organizer);
	public List<Organizer> findAllOrganizers();
	public Organizer findById(int id);
	public void update(Organizer organizer);
	public void delete(int id);
	public Organizer findByEmail(String email);
	
}
