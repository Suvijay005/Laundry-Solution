package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="users_tbl")
@Data
public class User extends BaseEntity {

	@Column(name="first_name", length = 30)
	private String firstName;
	@Column(name="last_name", length = 30)
	private String lastName;
	@Column(name="email", length = 60, nullable = false, unique = true)
	private String email;
	@Column(name="contact_no", length = 14)
	private String contactNo;
	@Column(name="password", length = 30, nullable = false)
	private String password;
	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
	@JsonIgnore
	@OneToMany (mappedBy = "user" ,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Order>orderlist=new ArrayList<Order>();
	
	
}
