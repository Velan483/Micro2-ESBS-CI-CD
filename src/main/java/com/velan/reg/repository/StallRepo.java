package com.velan.reg.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.velan.reg.model.Stall;

@Repository
public interface StallRepo {
	
	public void add(Stall stall);
	public List<Stall> findAllStalls();
	public Stall findById(int id);
	public void update(Stall stall);
	public void delete(int id);
	public List<Stall> findByOrganizerName(String name);
	public List<Stall> findByEventVenue(String eventVenue);
	public Stall findByEventName(String eventName);

}
