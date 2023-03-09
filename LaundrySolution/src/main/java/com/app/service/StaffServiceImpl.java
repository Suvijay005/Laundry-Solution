package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.pojos.Staff;
import com.app.repository.StaffRepository;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepository staffRepo;

	@Override
	public List<Staff> getAllStaff() {

		return staffRepo.findAll();
	}

	@Override
	public Staff getStaffDetails(Long id) {

		return staffRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid id!"));
	}

	@Override
	public Staff addStaff(Staff transientStaff) {
		return staffRepo.save(transientStaff);
	}

	@Override
	public String removeStaff(Long id) {
		if (staffRepo.existsById(id)) {
			staffRepo.deleteById(id);
			return "staff entry deleted successfully!";
		}
		return "deletion failed!Invalid staff id";
	}

	@Override
	public Staff modifyStaffDetails(Staff detachedStaff) {
		if (staffRepo.existsById(detachedStaff.getId())) {
			return staffRepo.save(detachedStaff);
		}
		throw new ResourceNotFoundException("Invalid id!");
	}

}
