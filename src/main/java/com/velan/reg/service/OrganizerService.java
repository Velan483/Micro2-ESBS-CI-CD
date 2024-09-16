package com.velan.reg.service;

import java.util.List;
import com.velan.reg.model.Organizer;

public interface OrganizerService {

	public String addOrganizer(Organizer organizer);
	public Organizer getOrganizer(int id);
	public List<Organizer> getAllOrganizers();
	public void updateOrganizer(Organizer organizer);
	public void deleteOrganizer(int id);
	public Organizer findByEmail(String email);
	
}
