package com.velan.reg.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.velan.reg.model.Exhibition;
import com.velan.reg.model.ExhibitionResponse;
import com.velan.reg.serviceimpl.ExhibitionServiceImp;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/exhibition")
@CrossOrigin("http://localhost:3000")
public class ExhibitionController {

	@Autowired
	ExhibitionServiceImp service;
	
	static final String SUCCESS="Success";
	static final String FAILURE="Failure";

	@PostMapping
	public ExhibitionResponse insertExhibition(@RequestBody Exhibition exhibition) {
	    ExhibitionResponse response;
	    try {
	        Exhibition savedExhibition = service.addExhibition(exhibition);
	        response = new ExhibitionResponse(SUCCESS, savedExhibition.getExhibitionId()); 
	    } catch (Exception e) {
	        response = new ExhibitionResponse(FAILURE, -1);
	    }
	    return response;
	}

	
	@GetMapping("{id}")
	public Exhibition getExhibitionById(@PathVariable("id") int id) {
		return service.getExhibition(id);
	}

	@GetMapping("/all")
	public List<Exhibition> getExhibitions() {
		return service.getAllExhibitions();
	}
	
	@PutMapping()
	public String updateExhibition(@RequestBody Exhibition exhibition) {
		String msg = "";

		try {
			service.updateExhibition(exhibition);
			msg = SUCCESS;
		}
		catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}
	
	@DeleteMapping("{id}")
	public String deleteExhibitionById(@PathVariable("id")int id) {
		String msg="";
		try {
			service.deleteExhibition(id);
			msg=SUCCESS;
		} 
		catch (Exception e) {
			msg=FAILURE;
		}
		return msg;
	}
 
}

