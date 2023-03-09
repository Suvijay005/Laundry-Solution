package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "staff_member")
@Data
public class Staff extends BaseEntity {
	@Column(name = "first_name", length = 30)
	private String firstName;
	@Column(name = "last_name", length = 30)
	private String lastName;
	@Column(name = "email", length = 30)
	private String email;
	@Column(name = "phone_number", length = 14)
	private String phoneNumber;
    @JsonIgnore
	@OneToMany(mappedBy = "staff" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	private List<Order> orderlist = new ArrayList<Order>();
    @JsonIgnore
	@OneToOne(mappedBy = "staff", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Inventory inventory;

}
