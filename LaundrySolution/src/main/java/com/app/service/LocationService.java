package com.app.service;

import java.util.List;

import com.app.pojos.Location;

public interface LocationService {

	List<Location> getAllLocation();
	
	Location getLocationById(Long id);
	
	Location addLocation(Location transientLocation);
	
	Location editLocationDetails(Location detachedLocation);
	
	String deleteLocationDetails(Long id);
}
