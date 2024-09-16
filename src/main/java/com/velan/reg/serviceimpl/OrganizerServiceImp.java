package com.velan.reg.serviceimpl;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.velan.reg.model.Organizer;
import com.velan.reg.repository.OrganizerRepo;
import com.velan.reg.service.OrganizerService;

@Service
public class OrganizerServiceImp implements OrganizerService {

	@Autowired
	OrganizerRepo repo;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
    public String addOrganizer(Organizer organizer) {
		organizer.setPassword(bcryptPasswordEncoder.encode(organizer.getPassword()));
        repo.add(organizer);
        return "Registered Successfully";
    }

    @Override
    public Organizer findByEmail(String email) {
        return repo.findByEmail(email);
    }

	@Override
	public Organizer getOrganizer(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Organizer> getAllOrganizers() {
		return repo.findAllOrganizers();
	}

	@Override
	public void updateOrganizer(Organizer organizer) {
		repo.update(organizer);
	}

	@Override
	public void deleteOrganizer(int id) {
		repo.delete(id);
	}
	
	public String updateProfilePhoto(int organizerId, MultipartFile file) throws IOException {
        Organizer organizer = repo.findById(organizerId);

        byte[] imageBytes = file.getBytes();
        organizer.setProfileImage(imageBytes);
        repo.add(organizer);
        return generatePhotoUrl(organizerId);
    }

    private String generatePhotoUrl(int organizerId) {
        return "http://localhost:8090/organizer/photos/" + organizerId;
    }
    

}
