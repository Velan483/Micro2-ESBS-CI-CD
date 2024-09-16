package com.velan.reg.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.velan.reg.model.Exhibition;

@Repository
public interface ExhibitionRepo {
	
	public void add(Exhibition exhibition);
	public List<Exhibition> findAllExhibitions();
	public Exhibition findById(int id);
	public void update(Exhibition exhibition);
	public void delete(int id);

}
