package com.app.pojos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "payments_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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
