package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "location_tbl")
@Data
public class Location extends BaseEntity {

	@Column(length = 30)
	private String name;
	@Column(length = 100)
	private String address;
	@Column(length = 14)
	private String phoneNumber;
	
	@OneToOne
	@JoinColumn(name = "orderdeliver")
	private Order orderDeliver;
}
