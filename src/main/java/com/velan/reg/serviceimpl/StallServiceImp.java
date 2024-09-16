package com.velan.reg.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.velan.reg.model.Stall;
import com.velan.reg.repository.StallRepo;
import com.velan.reg.service.StallService;

@Service
public class StallServiceImp implements StallService {

	@Autowired
	StallRepo repo;
	
	@Override
	public void addStall(Stall stall) {
		repo.add(stall);
	}

	@Override
	public Stall getStall(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Stall> getAllStalls() {
		return repo.findAllStalls();
	}

	@Override
	public void updateStall(Stall stall) {
		repo.update(stall);
	}

	@Override
	public void deleteStall(int id) {
		repo.delete(id);
	}
	
	@Override
    public List<Stall> findByOrganizerName(String name) {
        return repo.findByOrganizerName(name);
    }

	@Override
    public List<Stall> findByEventVenue(String eventVenue) {
        return repo.findByEventVenue(eventVenue);
    }
	
	@Override
    public Stall findByEventName(String eventName) {
        return repo.findByEventName(eventName);
    }
	
	public boolean updateAvailableStall(int stallId, int availableStall) {
        Stall stall = repo.findById(stallId);
        if (stall != null) {
            stall.setAvailableStall(availableStall);
            repo.update(stall); 
            return true;
        }
        return false;
    }
}
