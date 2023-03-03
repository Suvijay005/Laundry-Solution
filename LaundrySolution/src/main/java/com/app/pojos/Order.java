package com.app.pojos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "orders_tbl")
@Data
public class Order extends BaseEntity {
	@Column(name = "pickup_date", nullable = false)
	private LocalDateTime pickupDate;
	@Column(name = "delivery_date", nullable = false)
	private LocalDateTime deliveryDate;
	@Column(name = "status", length = 50)
	private String status;
	@Column(name = "instructions")
	private String instructions;
	@Column(name = "service_type")
	private String serviceType;

	@ManyToOne
	@JoinColumn(name = "userjoin")
	private User user;

	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Payment payment;

	@OneToOne(mappedBy = "orderDeliver", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Location location;

	@ManyToOne
	@JoinColumn(name = "staffjoin")
	private Staff staff;
	
	@OneToMany(mappedBy = "laundryorder",cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<LaundryItem> laundryItemsList=new ArrayList<LaundryItem>();
	

}
