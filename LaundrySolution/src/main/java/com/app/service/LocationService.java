package com.app.service;

import java.util.List;

import com.app.dto.LocationOrder;
import com.app.pojos.Location;

public interface LocationService {

	List<Location> getAllLocation();
	
	Location getLocationById(Long id);
	
	Location addLocation(LocationOrder dto);
	
	Location editLocationDetails(Location detachedLocation);
	
	String deleteLocationDetails(Long id);
}
