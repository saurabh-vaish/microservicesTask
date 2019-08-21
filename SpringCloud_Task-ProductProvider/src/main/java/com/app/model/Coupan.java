package com.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupan {


	
	private Integer coupanId;
	
	private String coupanCode;
	
	private Double coupanDisc;
	
	private String expDate;
	
	@JsonIgnore
	private Boolean applied=false;
	
}
