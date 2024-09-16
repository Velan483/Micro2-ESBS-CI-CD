package com.velan.reg.serviceimpl;


import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.velan.reg.model.Exhibitor;
import com.velan.reg.repository.ExhibitorRepo;
import com.velan.reg.service.ExhibitorService;

@Service
public class ExhibitorServiceImp implements ExhibitorService {

	@Autowired
	ExhibitorRepo repo;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
    public String addExhibitor(Exhibitor exhibitor) {
		exhibitor.setPassword(bcryptPasswordEncoder.encode(exhibitor.getPassword()));
        repo.add(exhibitor);
        return "Registered Successfully";
    }

    @Override
    public Exhibitor findByEmail(String email) {
        return repo.findByEmail(email);
    }

	@Override
	public Exhibitor getExhibitor(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Exhibitor> getAllExhibitors() {
		return repo.findAllExhibitors();
	}

	@Override
	public void updateExhibitor(Exhibitor exhibitor) {
		repo.update(exhibitor);
	}

	@Override
	public void deleteExhibitor(int id) {
		repo.delete(id);
	}

	public String updateProfilePhoto(int exhibitorId, MultipartFile file) throws IOException {
        Exhibitor exhibitor = repo.findById(exhibitorId);

        byte[] imageBytes = file.getBytes();
        exhibitor.setProfileImage(imageBytes);
        repo.add(exhibitor);
        return generatePhotoUrl(exhibitorId);
    }

    private String generatePhotoUrl(int exhibitorId) {
        return "http://localhost:8090/exhibitor/photos/" + exhibitorId;
    }
	
	
}
