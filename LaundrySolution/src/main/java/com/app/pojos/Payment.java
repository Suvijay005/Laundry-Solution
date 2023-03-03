package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "payments_tbl")
@Data
public class Payment extends BaseEntity {
	@Column(name = "amount")
	private double amount;
	@Column(name = "payment_method", length = 20)
	private String paymentMethod;
	@Column(name = "status", length = 40)
	private String status;
	
	
	@OneToOne
	@JoinColumn(name = "order_join")
	private Order order;
	
}
