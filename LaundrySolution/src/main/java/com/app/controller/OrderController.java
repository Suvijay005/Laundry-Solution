package com.app.controller;

import java.time.LocalDateTime;
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

import com.app.pojos.Order;
import com.app.service.OrderService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping
	public List<Order> getAllOrderDetails() {
		return orderService.getAllOrders();
	}

	@PostMapping
	public Order saveOrderDetails(@RequestBody Order transientOrder) {
		return orderService.addOrder(transientOrder);
	}

	@GetMapping("{id}")
	public Order getOrderById(@PathVariable Long id) {
		return orderService.getOrderDetails(id);
	}

	@PutMapping
	public Order updateOrderDetails(@RequestBody Order detachedOrder) {
		return orderService.modifyOrder(detachedOrder);
	}

	@DeleteMapping("{id}")
	public String deleteOrderDetails(@PathVariable Long id) {
		return orderService.deleteOrder(id);
	}

	@GetMapping("/pickupdate/{date}")
	public List<Order> getOrderByPickUpDate(@PathVariable String date) {
		return orderService.getOrdersByPickupDate(date);
	}

	@GetMapping("/deliverydate/{date}")
	public List<Order> getOrdersByDeliveryDate(@PathVariable String date) {
		return orderService.getOrdersByDeliveryupDate(date);

	}
}