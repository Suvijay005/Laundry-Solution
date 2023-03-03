package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "laundry_tbl")
@Data
public class LaundryItem extends BaseEntity {

	@Column(name="name",length = 32)
	private String name;
	@Column(name = "price")
	private double price;
	@ManyToOne
	@JoinColumn(name="laundryorderjoin")
	private Order laundryorder;
}
