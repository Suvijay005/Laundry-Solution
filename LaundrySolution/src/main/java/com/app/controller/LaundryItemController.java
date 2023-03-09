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

import com.app.pojos.LaundryItem;
import com.app.service.LaundryItemService;

@RestController
@RequestMapping("/laundryitem")
public class LaundryItemController {

	@Autowired
	private LaundryItemService laundryItemService;

	@GetMapping
	public List<LaundryItem> fetchAllLaundryItems() {
		return laundryItemService.getAllLaundryItems();
	}

	@PostMapping
	public LaundryItem addNewItem(@RequestBody LaundryItem transientLaundryItem) {
		return laundryItemService.addLaundryItem(transientLaundryItem);
	}

	@GetMapping("/{id}")
	public LaundryItem fetchItemById(@PathVariable Long id) {
		return laundryItemService.getLaundryItemDetails(id);
	}

	@PutMapping
	public LaundryItem modifyLaundryItemDetails(@RequestBody LaundryItem detachedLaundryItem) {
		return laundryItemService.editLaundryItemDetails(detachedLaundryItem);
	}

	@DeleteMapping("/{id}")
	public String deleteLaundryItem(@PathVariable Long id) {
		return laundryItemService.deleteLaundryItemDetails(id);

	}
}
