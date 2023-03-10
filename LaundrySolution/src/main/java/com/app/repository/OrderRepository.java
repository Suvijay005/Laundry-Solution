package com.app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	 List<Order> findByPickupDateBetween(LocalDateTime startDate, LocalDateTime endDate);
	 //List<Order> findByDeliveryDate(LocalDateTime deliverydate);
     List<Order> findByDeliveryDateBetween(LocalDateTime startDate, LocalDateTime endDate);


}

