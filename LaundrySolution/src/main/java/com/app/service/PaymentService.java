package com.app.service;

import java.util.List;

import com.app.pojos.Payment;

public interface PaymentService {

	List<Payment> getAllPayments();
	
	Payment getPaymentDetailsById(Long id);
	
	Payment addPayment(Payment transientPayment);
	
	Payment editPaymentDetails(Payment detachedPayment);
	
	String deletePaymentDetails(Long id);
	
}
