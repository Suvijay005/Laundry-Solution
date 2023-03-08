package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.pojos.Inventory;
import com.app.repository.InventoryRepository;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepo;

	@Override
	public List<Inventory> getCompleteInventory() {
		
		return inventoryRepo.findAll();
	}	
	
	@Override
	public Inventory addInventory(Inventory transientInventory) {
		return inventoryRepo.save(transientInventory);
	}
	
	@Override
	public Inventory getDetailsByProductName(String productName1) {
		
		return inventoryRepo.findByProductName(productName1);
	}
	
	@Override
	public Inventory modifyInventory(Inventory detachedInventory) {
		if(inventoryRepo.existsById(detachedInventory.getId())) {
			return inventoryRepo.save(detachedInventory);
		}
		throw new ResourceNotFoundException("Invalid inventory name!");
	}
	
	@Override
	public String deletefromInventory(Long id) {
		if(inventoryRepo.existsById(id)) {
			inventoryRepo.deleteById(id);
			return "Entry deleted from inventory successfully!";
		}
		return "Deletion failed!Invalid id";
	}
	
	
}
