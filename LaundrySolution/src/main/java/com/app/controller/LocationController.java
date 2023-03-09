package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Location;
import com.app.service.LocationService;

@RestController
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@GetMapping
	public List<Location> fetchAllLocations(){
		return locationService.getAllLocation();
	}
	
	@PostMapping
	public Location addLocationDetails(@RequestBody Location transientLocation) {
		return locationService.addLocation(transientLocation);
	}
	
	@PutMapping
	public Location modifyLocationDetails(@RequestBody Location detachedLocation) {
		return locationService.editLocationDetails(detachedLocation);
	}
	
	@GetMapping("/{id}")
	public Location fetchLocationById(@PathVariable Long id) {
		return locationService.getLocationById(id);
		
	} 
	
	@DeleteMapping("/{id}")
	public String deleteLocation(@PathVariable Long id) {
		return locationService.deleteLocationDetails(id);
	}
	
}
