package com.velan.reg.service;

import java.util.List;

import com.velan.reg.model.Exhibition;

public interface ExhibitionService {
	
	public Exhibition addExhibition(Exhibition exhibition);
	public Exhibition getExhibition(int id);
	public List<Exhibition> getAllExhibitions();
	public void updateExhibition(Exhibition exhibition);
	public void deleteExhibition(int id);

}
