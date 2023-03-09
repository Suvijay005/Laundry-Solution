package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.pojos.Location;
import com.app.repository.LocationRepository;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

@Autowired
private LocationRepository locationRepo;
	
	@Override
		public List<Location> getAllLocation() {
			
			return locationRepo.findAll();
		}
	
	@Override
		public Location getLocationById(Long id) {
		
			return locationRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Invalid id!"));
		}
	
	@Override
		public Location addLocation(Location transientLocation) {
			
			return locationRepo.save(transientLocation);
		}
	
	@Override
		public Location editLocationDetails(Location detachedLocation) {
		if(locationRepo.existsById(detachedLocation.getId())) {
			return locationRepo.save(detachedLocation);
		}
		throw new ResourceNotFoundException("Invalid id!");
		
		}
	
	@Override
		public String deleteLocationDetails(Long id) {
		if(locationRepo.existsById(id)) {
			locationRepo.deleteById(id);
			return "Location details deleted successfully!";
		
		}
		return "Deletion failed!Invalid id";
		}
	
	
}
