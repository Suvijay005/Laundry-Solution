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
@Table(name = "location_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Location extends BaseEntity {

	@Column(length = 30)
	private String name;
	@Column(length = 100)
	private String address;
	@Column(length = 14)
	private String phoneNumber;
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "orderdeliver")
	@MapsId
	private Order orderDeliver;
}
