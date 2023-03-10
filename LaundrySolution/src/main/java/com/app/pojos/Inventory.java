package com.app.pojos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="inventory")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Inventory extends BaseEntity {
    @Column(name = "product_name", length = 40, unique=true)
	private String productName;
    @Column(name = "product_quantity")
	private int productQuantity;
    @Column(name = "product_stock")
	private String productStock;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "staffjoin")
    @MapsId
    private Staff staff;
    
}
