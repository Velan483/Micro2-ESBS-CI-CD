package com.velan.reg.service;

import java.util.List;
import com.velan.reg.model.Stall;

public interface StallService {
	
	public void addStall(Stall stall);
	public Stall getStall(int id);
	public List<Stall> getAllStalls();
	public void updateStall(Stall stall);
	public void deleteStall(int id);
	public List<Stall> findByOrganizerName(String name);
	public List<Stall> findByEventVenue(String eventVenue);
	public Stall findByEventName(String eventName);

}
