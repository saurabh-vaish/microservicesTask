package com.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product_micro")
public class Product implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	private Integer prodId;
	
	private String prodCode;
	
	private Double prodCost;
	
	@JsonIgnore
	private Double finalCost;
	
	@Transient
	private Coupan coupan;	
	
}
