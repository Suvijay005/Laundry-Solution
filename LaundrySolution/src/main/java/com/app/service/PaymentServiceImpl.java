package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.PaymentOrder;
import com.app.pojos.Order;
import com.app.pojos.Payment;
import com.app.repository.OrderRepository;
import com.app.repository.PaymentRepository;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepo;
     @Autowired
     private OrderRepository orderRepo;
	@Override
	public List<Payment> getAllPayments() {

		return paymentRepo.findAll();
	}

	@Override
	public Payment getPaymentDetailsById(Long id) {
	
		return paymentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Invalid id!"));
		
	}
	
	
	
	@Override
	public Payment addPayment(PaymentOrder dto) {
		Order order=orderRepo.findById(dto.getId()).orElseThrow(()-> new ResourceNotFoundException("Order does not exist for this payment!"));
	Payment transientPayment=new Payment(dto.getAmount(), dto.getPaymentMethod(), dto.getStatus(), order);
		return paymentRepo.save(transientPayment);
	}
	
	@Override
	public Payment editPaymentDetails(Payment detachedPayment) {
		if(paymentRepo.existsById(detachedPayment.getId())) {
		return paymentRepo.save(detachedPayment);
		}
		throw new ResourceNotFoundException("invalid id!");
	}
	
	@Override
	public String deletePaymentDetails(Long id) {
	if(paymentRepo.existsById(id)) {
		paymentRepo.deleteById(id);
		return "Payment details deleted successfully";
	}
		return "Deletion failed!Invalid id";
	}
	
	
	
}
