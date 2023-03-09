package com.app.pojos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "order_join")
	@MapsId
	private Order order;
	
}
