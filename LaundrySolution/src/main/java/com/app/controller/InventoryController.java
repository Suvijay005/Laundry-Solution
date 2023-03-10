package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.InventoryStaff;
import com.app.pojos.Inventory;
import com.app.service.InventoryService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping
	public List<Inventory>getAllInventory()
	{
		return inventoryService.getCompleteInventory();
	}
	
	@PostMapping
	public Inventory addNewInventory(@RequestBody InventoryStaff dto) {
return inventoryService.addInventory(dto);
	}
	
	@GetMapping("/{productname}")
	public Inventory fetchInventoryDetailsByName(@PathVariable String productname) {
		return inventoryService.getDetailsByProductName(productname);
	}
	
	@PutMapping
	public Inventory editInventoryDetails(@RequestBody Inventory detachedInventory) {
		return inventoryService.modifyInventory(detachedInventory);
	}
	
	@DeleteMapping("/{id}")
	public String deleteInventoryDetails(@PathVariable Long id) {
		return inventoryService.deletefromInventory(id);
	}
	
	
	
	
}
