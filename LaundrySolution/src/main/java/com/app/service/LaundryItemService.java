package com.app.service;

import java.util.List;

import com.app.pojos.LaundryItem;

public interface LaundryItemService {

	List<LaundryItem> getAllLaundryItems();
	
	LaundryItem getLaundryItemDetails(Long id);
	
	LaundryItem addLaundryItem(LaundryItem transientLaunrdyItem);
	
	LaundryItem editLaundryItemDetails(LaundryItem detachedLaundryItem);
	
	String deleteLaundryItemDetails(Long id);
}
