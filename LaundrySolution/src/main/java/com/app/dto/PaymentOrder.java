package com.app.dto;

public class PaymentOrder {
private Long id;
private double amount;
private String paymentMethod;
private String status;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public String getPaymentMethod() {
	return paymentMethod;
}
public void setPaymentMethod(String paymentMethod) {
	this.paymentMethod = paymentMethod;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
