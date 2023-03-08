package com.app.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.app.pojos.Order;

public interface OrderService {
	List<Order> getAllOrders();

	Order getOrderDetails(Long id);

	Order addOrder(Order transientOrder);
	String deleteOrder(Long id);
	Order modifyOrder(Order detachedOrder);
	List<Order> getOrdersByPickupDate(LocalDateTime pickupdate1);
	List<Order> getOrdersByDeliveryupDate(LocalDateTime deliverydate1);
	
}
