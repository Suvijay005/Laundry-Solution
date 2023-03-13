package com.app.service;

import java.util.List;

import com.app.dto.InventoryStaff;
import com.app.pojos.Inventory;

public interface InventoryService {

	List<Inventory> getCompleteInventory();

	Inventory addInventory(InventoryStaff dto);

	Inventory getDetailsByProductName(String productName1);

	Inventory modifyInventory(Inventory detachedInventory);
	
	String deletefromInventory(Long id);

	
}
