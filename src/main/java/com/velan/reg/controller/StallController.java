package com.velan.reg.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.velan.reg.model.Exhibition;
import com.velan.reg.model.Stall;
import com.velan.reg.serviceimpl.ExhibitionServiceImp;
import com.velan.reg.serviceimpl.StallServiceImp;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/stall")
@CrossOrigin("http://localhost:3000")
public class StallController {

	@Autowired
	StallServiceImp service;
	
	@Autowired
	ExhibitionServiceImp exhibitionService;
	
	static final String SUCCESS="Success";
	static final String FAILURE="Failure";
	
	@PostMapping
	public String insertStall(
	    @RequestParam("totalStall") int totalStall,
	    @RequestParam("availableStall") int availableStall,
	    @RequestParam("stallType") String stallType,
	    @RequestParam("rent") int rent,
	    @RequestParam("stallModel") String stallModel,
	    @RequestParam("eventPoster") MultipartFile eventPoster,
	    @RequestParam("floorPlan") MultipartFile floorPlan,
	    @RequestParam("visitorCount") int visitorCount,
	    @RequestParam("exhibitionId") int exhibitionId) {
	    
	    String msg = "";
	    try {
	    	
	        byte[] eventPosterBytes = eventPoster.getBytes();
	        byte[] floorPlanBytes = floorPlan.getBytes();
	        
	        Exhibition exhibition = exhibitionService.getExhibition(exhibitionId);
	        
	        Stall stall = new Stall();
	        stall.setTotalStall(totalStall);
	        stall.setAvailableStall(availableStall);
	        stall.setStallType(stallType);
	        stall.setRent(rent);
	        stall.setStallModel(stallModel);
	        stall.setEventPoster(eventPosterBytes);
	        stall.setFloorPlan(floorPlanBytes);
	        stall.setVisitorCount(visitorCount);
	        stall.setExhibition(exhibition);
	        
	        // Call service to add stall
	        service.addStall(stall);
	        msg = "Success";
	    } catch (Exception e) {
	        msg = "Failure";
	    }
	    return msg;
	}


	@GetMapping("{id}")
	public Stall getStallById(@PathVariable("id") int id) {
		return service.getStall(id);
	}

	@GetMapping("/all")
	public List<Stall> getStalls() {
		return service.getAllStalls();
	}
	
//	@PutMapping
//	public ResponseEntity<String> updateStall(
//	    @RequestParam("stallId") int stallId,
//	    @RequestParam("totalStall") int totalStall,
//	    @RequestParam("availableStall") int availableStall,
//	    @RequestParam("stallType") String stallType,
//	    @RequestParam("rent") int rent,
//	    @RequestParam("stallModel") String stallModel,
//	    @RequestParam(value = "eventPoster", required = false) MultipartFile eventPoster,
//	    @RequestParam(value = "floorPlan", required = false) MultipartFile floorPlan,
//	    @RequestParam("visitorCount") int visitorCount,
//	    @RequestParam("exhibitionId") int exhibitionId) {
//	    
//	    try {
//	        // Retrieve the existing stall
//	        Stall stall = service.getStall(stallId);
//	        if (stall == null) {
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stall not found");
//	        }
//	        
//	        // Update fields
//	        stall.setTotalStall(totalStall);
//	        stall.setAvailableStall(availableStall);
//	        stall.setStallType(stallType);
//	        stall.setRent(rent);
//	        stall.setStallModel(stallModel);
//	        stall.setVisitorCount(visitorCount);
//	        
//	        // Handle file uploads if provided
//	        if (eventPoster != null && !eventPoster.isEmpty()) {
//	            stall.setEventPoster(eventPoster.getBytes());
//	        }
//	        if (floorPlan != null && !floorPlan.isEmpty()) {
//	            stall.setFloorPlan(floorPlan.getBytes());
//	        }
//	        
//	        Exhibition exhibition = exhibitionService.getExhibition(exhibitionId);
//	        if (exhibition == null) {
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exhibition not found");
//	        }
//	        stall.setExhibition(exhibition);
//	        
//	        service.updateStall(stall);
//	        return ResponseEntity.ok("Stall updated successfully");
//	    } catch (Exception e) {
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failure");
//	    }
//	}
	
	   @PutMapping
	    public ResponseEntity<String> updateStall(
	        @RequestParam("stallId") int stallId,
	        @RequestParam("totalStall") int totalStall,
	        @RequestParam("availableStall") int availableStall,
	        @RequestParam("stallType") String stallType,
	        @RequestParam("rent") int rent,
	        @RequestParam("stallModel") String stallModel,
	        @RequestParam("visitorCount") int visitorCount,
	        @RequestParam(value = "eventPoster", required = false) MultipartFile eventPoster,
	        @RequestParam(value = "floorPlan", required = false) MultipartFile floorPlan,
	        @RequestParam("exhibitionName") String exhibitionName,
	        @RequestParam("exhibitionOrganizer") String exhibitionOrganizer,
	        @RequestParam("exhibitionVenue") String exhibitionVenue,
	        @RequestParam("exhibitionStartDate") String exhibitionStartDate,
	        @RequestParam("exhibitionEndDate") String exhibitionEndDate,
	        @RequestParam("exhibitionVenueType") String exhibitionVenueType,
	        @RequestParam("exhibitionEventType") String exhibitionEventType,
	        @RequestParam("exhibitionId") int exhibitionId) {

	        try {
	            // Retrieve the existing stall
	            Stall stall = service.getStall(stallId);
	            if (stall == null) {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stall not found");
	            }
	            
	            // Update stall fields
	            stall.setTotalStall(totalStall);
	            stall.setAvailableStall(availableStall);
	            stall.setStallType(stallType);
	            stall.setRent(rent);
	            stall.setStallModel(stallModel);
	            stall.setVisitorCount(visitorCount);
	            
	            // Handle file uploads if provided
	            if (eventPoster != null && !eventPoster.isEmpty()) {
	                stall.setEventPoster(eventPoster.getBytes());
	            }
	            if (floorPlan != null && !floorPlan.isEmpty()) {
	                stall.setFloorPlan(floorPlan.getBytes());
	            }
	            
	            // Retrieve and update exhibition details
	            Exhibition exhibition = exhibitionService.getExhibition(exhibitionId);
	            if (exhibition == null) {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exhibition not found");
	            }
	            
	            exhibition.setEventName(exhibitionName);
	            exhibition.setOrganizerName(exhibitionOrganizer);
	            exhibition.setEventVenue(exhibitionVenue);

	            // Convert string dates to java.sql.Date
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	            exhibition.setStartDate(Date.valueOf(LocalDate.parse(exhibitionStartDate, formatter)));
	            exhibition.setEndDate(Date.valueOf(LocalDate.parse(exhibitionEndDate, formatter)));

	            exhibition.setVenueType(exhibitionVenueType);
	            exhibition.setEventType(exhibitionEventType);
	            
	            stall.setExhibition(exhibition);
	            
	            // Update the stall
	            service.updateStall(stall);
	            return ResponseEntity.ok("Stall updated successfully");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failure");
	        }
	    }
	   
	@DeleteMapping("{id}")
	public String deleteStallById(@PathVariable("id")int id) {
		String msg="";
		try {
			service.deleteStall(id);
			msg=SUCCESS;
		} 
		catch (Exception e) {
			msg=FAILURE;
		}
		return msg;
	}
	
	@GetMapping("/name/{name}")
    public List<Stall> getStallByOrganizerName(@PathVariable("name") String name) {
        return service.findByOrganizerName(name);
    }
	
	@GetMapping("/eventVenue/{eventVenue}") 
    public List<Stall> getStallByEventVenue(@PathVariable("eventVenue") String eventVenue) {
        return service.findByEventVenue(eventVenue);
    }
	
	@GetMapping("/eventName/{eventName}") 
    public Stall getStallByEventName(@PathVariable("eventName") String eventName) {
        return service.findByEventName(eventName);
    }
	
    @PatchMapping
    public ResponseEntity<String> updateStallAvailability(
        @RequestParam("stallId") int stallId,
        @RequestParam("availableStall") int availableStall) {
        
        try {
            boolean updated = service.updateAvailableStall(stallId, availableStall);
            if (updated) {
                return ResponseEntity.ok("Stall availability updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stall not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failure");
        }
    }
 
}

