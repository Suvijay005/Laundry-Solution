package com.app.service;

import java.util.List;

import com.app.pojos.Order;

public interface OrderService {
	List<Order> getAllOrders();

	Order getOrderDetails(Long id);

	Order addOrder(Order transientOrder);
	String deleteOrder(Long id);
	Order modifyOrder(Order detachedOrder);
	List<Order> getOrdersByPickupDate(String pickupdate1);
	List<Order> getOrdersByDeliveryupDate(String deliverydate1);
	
}
