package com.velan.reg.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.velan.reg.model.Exhibition;
import com.velan.reg.repository.ExhibitionRepo;
import com.velan.reg.service.ExhibitionService;

@Service
public class ExhibitionServiceImp implements ExhibitionService {

	@Autowired
	ExhibitionRepo repo;
	
	@Override
	public Exhibition addExhibition(Exhibition exhibition) {
		repo.add(exhibition);
		return exhibition;
	}

	@Override
	public Exhibition getExhibition(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Exhibition> getAllExhibitions() {
		return repo.findAllExhibitions();
	}

	@Override
	public void updateExhibition(Exhibition exhibition) {
		repo.update(exhibition);
	}

	@Override
	public void deleteExhibition(int id) {
		repo.delete(id);
	}
		
}
