package com.velan.reg.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.velan.reg.model.LoginRequest;
import com.velan.reg.model.LoginResponse;
import com.velan.reg.model.Organizer;
import com.velan.reg.model.ProfilePhotoResponse;
import com.velan.reg.model.Exhibitor;
import com.velan.reg.serviceimpl.ExhibitorServiceImp;
import com.velan.reg.serviceimpl.OrganizerServiceImp;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/exhibitor")
@CrossOrigin("http://localhost:3000")
public class ExhibitorController {

	@Autowired
	ExhibitorServiceImp service;

	@Autowired
	OrganizerServiceImp oranizerService;

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	static final String SUCCESS = "Success";
	static final String FAILURE = "Failure";

	@PostMapping
	public String insertExhibitor(@RequestBody Exhibitor exhibitor) {
		String msg = "";
		try {
			service.addExhibitor(exhibitor);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}

	@PostMapping("/login")
	public ResponseEntity<?> doLogin(@RequestBody LoginRequest loginRequest) {

		// Authenticate Exhibitor
        Exhibitor exhibitor = service.findByEmail(loginRequest.getEmail());
        if (exhibitor != null && bcryptPasswordEncoder.matches(loginRequest.getPassword(), exhibitor.getPassword())) {

			LoginResponse loginResponse = new LoginResponse(exhibitor.getExhibitorId(), exhibitor.getRole(),
					exhibitor.getEmail(),exhibitor.getName(),exhibitor.getPhoneNumber());
			return ResponseEntity.ok(loginResponse);
		}

        //Authenticate Organizer
		Organizer organizer = oranizerService.findByEmail(loginRequest.getEmail());
		if (organizer != null && bcryptPasswordEncoder.matches(loginRequest.getPassword(), organizer.getPassword())) {

			LoginResponse loginResponse = new LoginResponse(organizer.getOrganizerId(), organizer.getRole(),
					organizer.getEmail(),organizer.getName(),organizer.getPhoneNumber());
			return ResponseEntity.ok(loginResponse);
		}

		// no user match
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");

	}

	@GetMapping("{id}")
	public Exhibitor getExhibitorById(@PathVariable("id") int id) {
		return service.getExhibitor(id);
	}

	@GetMapping("/all")
	public List<Exhibitor> getExhibitors() {
		return service.getAllExhibitors();
	}

	@PutMapping()
	public String updateExhibitor(@RequestBody Exhibitor exhibitor) {
		String msg = "";

		try {
			service.updateExhibitor(exhibitor);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}

	@DeleteMapping("{id}")
	public String deleteExhibitorById(@PathVariable("id") int id) {
		String msg = "";
		try {
			service.deleteExhibitor(id);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}

	
	@PatchMapping("/profile-photo/{exhibitorId}")
    public ResponseEntity<?> updateProfilePhoto(
        @PathVariable int exhibitorId,
        @RequestParam("profilePhoto") MultipartFile file) throws IOException {
        
        String photoUrl = service.updateProfilePhoto(exhibitorId, file);
        return ResponseEntity.ok().body(new ProfilePhotoResponse(photoUrl));
    }
}