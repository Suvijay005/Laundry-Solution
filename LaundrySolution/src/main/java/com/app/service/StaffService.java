package com.app.service;

import java.util.List;

import com.app.pojos.Staff;

public interface StaffService {

	List<Staff> getAllStaff();
	
	Staff addStaff(Staff transientStaff);
	
	String removeStaff(Long id);
	
	Staff modifyStaffDetails(Staff detachedStaff);
	

}
