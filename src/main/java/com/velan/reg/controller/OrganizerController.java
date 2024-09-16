package com.velan.reg.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.velan.reg.model.Organizer;
import com.velan.reg.model.ProfilePhotoResponse;
import com.velan.reg.serviceimpl.OrganizerServiceImp;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/organizer")
@CrossOrigin("http://localhost:3000")
public class OrganizerController {

	@Autowired
	OrganizerServiceImp service;
	
	static final String SUCCESS="Success";
	static final String FAILURE="Failure";

	@PostMapping
	public String insertOrganizer(@RequestBody Organizer organizer) {
		String msg = "";
		try {
			service.addOrganizer(organizer);
			msg = SUCCESS;
		}
		catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}
	
	@GetMapping("{id}")
	public Organizer getOrganizerById(@PathVariable("id") int id) {
		return service.getOrganizer(id);
	}

	@GetMapping("/all")
	public List<Organizer> getOrganizers() {
		return service.getAllOrganizers();
	}
	
	@PutMapping()
	public String updateOrganizer(@RequestBody Organizer organizer) {
		String msg = "";

		try {
			service.updateOrganizer(organizer);
			msg = SUCCESS;
		}
		catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}
	
	@DeleteMapping("{id}")
	public String deleteOrganizerById(@PathVariable("id")int id) {
		String msg="";
		try {
			service.deleteOrganizer(id);
			msg=SUCCESS;
		} 
		catch (Exception e) {
			msg=FAILURE;
		}
		return msg;
	}
	
	@PatchMapping("/profile-photo/{organizerId}")
    public ResponseEntity<?> updateProfilePhoto(
        @PathVariable int organizerId,
        @RequestParam("profilePhoto") MultipartFile file) throws IOException {
        
        String photoUrl = service.updateProfilePhoto(organizerId, file);
        return ResponseEntity.ok().body(new ProfilePhotoResponse(photoUrl));
    }

}