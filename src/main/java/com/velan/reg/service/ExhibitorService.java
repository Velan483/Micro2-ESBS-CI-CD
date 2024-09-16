package com.velan.reg.service;

import java.util.List;
import com.velan.reg.model.Exhibitor;

public interface ExhibitorService {

	public String addExhibitor(Exhibitor exhibitor);
	public Exhibitor getExhibitor(int id);
	public List<Exhibitor> getAllExhibitors();
	public void updateExhibitor(Exhibitor exhibitor);
	public void deleteExhibitor(int id);
	public Exhibitor findByEmail(String email);
	
}
