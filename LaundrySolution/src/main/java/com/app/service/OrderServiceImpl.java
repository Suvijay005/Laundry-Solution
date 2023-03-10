package com.app.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.pojos.Order;
import com.app.repository.OrderRepository;
@Service
@Transactional
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepo;
	
	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}
	@Override
	public Order getOrderDetails(Long id) {
		
		return orderRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid order id"));
	}
	@Override
	public Order addOrder(Order transientOrder) {
		
		return orderRepo.save(transientOrder);
	}
	@Override
	public String deleteOrder(Long orderId) {
		if(orderRepo.existsById(orderId)) {
		orderRepo.deleteById(orderId);
			return "Order details deleted successfully";
		}
		return "Deletion failed:Invalid orderId!";
	}
	@Override
	public Order modifyOrder(Order detachedOrder) {
		if(orderRepo.existsById(detachedOrder.getId())) {
			return orderRepo.save(detachedOrder);
		}
		throw new ResourceNotFoundException("Updation failed:Invalid orderId!");
	}
	@Override
	public List<Order> getOrdersByPickupDate(String pickupdate1) {
		
		return orderRepo.findByPickupDateBetween(LocalDateTime.parse(pickupdate1), LocalDateTime.parse(pickupdate1).plusDays(1));
	}

	
	@Override
	public List<Order> getOrdersByDeliveryupDate(String deliverydate1) {
		
		return orderRepo.findByDeliveryDateBetween(LocalDateTime.parse(deliverydate1), LocalDateTime.parse(deliverydate1).plusDays(1));
	}
	
	
}
