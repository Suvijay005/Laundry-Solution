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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order extends BaseEntity {
	@Column(name = "pickup_date", nullable = false)
	private LocalDateTime pickupDate;
	@Column(name = "delivery_date")
	private LocalDateTime deliveryDate;
	@Column(name = "status", length = 50)
	private String status;
	@Column(name = "instructions")
	private String instructions;
	@Column(name = "service_type")
	private String serviceType;
    @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "userjoin")
	private User user;
    @JsonIgnore
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Payment payment;
    @JsonIgnore
	@OneToOne(mappedBy = "orderDeliver", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Location location;
    @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "staffjoin")
	private Staff staff;
	@JsonIgnore
	@OneToMany(mappedBy = "laundryorder",cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<LaundryItem> laundryItemsList=new ArrayList<LaundryItem>();
	

}
