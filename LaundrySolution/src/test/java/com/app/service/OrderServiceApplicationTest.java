package com.app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.Order;

@SpringBootTest
public class OrderServiceApplicationTest {
	@Autowired
	private OrderService os;
	
	@Test
		void addOrderTest() {
		os.addOrder(new Order());
		
	}
	@Test
	void getAllOrderTest() {
		
	os.deleteOrder(1l);
	
	
	}
}
