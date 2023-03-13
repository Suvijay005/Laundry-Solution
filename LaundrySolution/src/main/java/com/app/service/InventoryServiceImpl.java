package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.InventoryStaff;
import com.app.pojos.Inventory;
import com.app.pojos.Staff;
import com.app.repository.InventoryRepository;
import com.app.repository.StaffRepository;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepo;

	@Autowired
	private StaffRepository staffRepo;
	
	@Override
	public List<Inventory> getCompleteInventory() {
		
		return inventoryRepo.findAll();
	}	
	
	@Override
	public Inventory addInventory(InventoryStaff dto) {
		Staff staff=staffRepo.findById(dto.getId()).orElseThrow(()-> new ResourceNotFoundException("Invalid staff id"));
		Inventory transientInventory=new Inventory(dto.getProductName(),dto.getProductQuantity(), dto.getProductStock(), staff);
		
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
