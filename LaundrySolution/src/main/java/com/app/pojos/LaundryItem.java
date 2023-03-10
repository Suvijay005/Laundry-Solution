package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "laundry_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LaundryItem extends BaseEntity {

	@Column(name="name",length = 32)
	private String name;
	@Column(name = "price")
	private double price;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="laundryorderjoin")
	private Order laundryorder;
}
