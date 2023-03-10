package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Staff;
import com.app.service.StaffService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	@GetMapping
	public List<Staff> fetchAllStaff(){
		return staffService.getAllStaff();
	}
	
	@PostMapping
	public Staff addNewStaff(@RequestBody Staff transientStaff) {
		return staffService.addStaff(transientStaff);
	}
	
	@GetMapping("/{id}")
	public Staff fetchStaffDetails(@PathVariable Long id) {
		return staffService.getStaffDetails(id);
	}
	
	@PutMapping
	public Staff editStaffDetails(@RequestBody Staff detachedStaff) {
		return staffService.modifyStaffDetails(detachedStaff);
	}
	
	@DeleteMapping("/{id}")
	public String deleteStaff(@PathVariable Long id) {
		return staffService.removeStaff(id);
	}
	
	
	
}
