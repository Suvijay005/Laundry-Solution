package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.pojos.LaundryItem;
import com.app.repository.LaundryItemRepository;

@Service
@Transactional
public class LaundryItemServiceImpl implements LaundryItemService {

	@Autowired
	private LaundryItemRepository laundryItemRepo;
	
	@Override
	public List<LaundryItem> getAllLaundryItems() {
	
		return laundryItemRepo.findAll();
	}
	
	@Override
	public LaundryItem getLaundryItemDetails(Long id) {
	
		return laundryItemRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Invalid id!"));
	}
	
	 @Override
	public LaundryItem addLaundryItem(LaundryItem transientLaunrdyItem) {
		return laundryItemRepo.save(transientLaunrdyItem);
	}
	 
	 @Override
	public LaundryItem editLaundryItemDetails(LaundryItem detachedLaundryItem) {
	if(laundryItemRepo.existsById(detachedLaundryItem.getId())) {
	
		return laundryItemRepo.save(detachedLaundryItem);
	}
	throw new ResourceNotFoundException("Invalid id!");
	}
	
	
	@Override
	public String deleteLaundryItemDetails(Long id) {
	if(laundryItemRepo.existsById(id)) {
	     laundryItemRepo.deleteById(id);
		return "LaundryItem details deleted successfully";
		
	}
	return "Deletion failed!Invalid id";
	}
	
	
}
