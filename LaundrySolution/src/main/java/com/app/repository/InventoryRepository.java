package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	Inventory findByProductName(String productName);
	
	
	
	
}
