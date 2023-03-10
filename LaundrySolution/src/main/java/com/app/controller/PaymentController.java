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

import com.app.dto.PaymentOrder;
import com.app.pojos.Payment;
import com.app.service.PaymentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@GetMapping
	public List<Payment>fetchAllPayments(){
		return paymentService.getAllPayments();
	}
	
	@PostMapping
	public Payment addPaymentDetails(@RequestBody PaymentOrder dto) {
		return paymentService.addPayment(dto);
	}
	
	@GetMapping("/{id}")
	public Payment fetchPaymentDetails(@PathVariable Long id)
	{
		return paymentService.getPaymentDetailsById(id);
	}
	
	@PutMapping
	public Payment mofidyPaymentDetails(@RequestBody Payment detachedPayment) {
		return paymentService.editPaymentDetails(detachedPayment);
	}
	
	@DeleteMapping("/{id}")
	public String deletePayment(@PathVariable Long id) {
		return paymentService.deletePaymentDetails(id);
	}
	
	
}
