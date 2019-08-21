package com.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="coupan_micro")
public class Coupan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="coupan_id")
	private Integer coupanId;
	
	@Column(name="coupan_code")
	private String coupanCode;
	
	@Column(name="coupan_discount")
	private Double coupanDisc;
	
	@Column(name="coupan_expiry")
	@Temporal(TemporalType.DATE)
	private Date expDate;
	
	@JsonIgnore
	@Column(name="coupan_valid")
	private Boolean isValid = true;
	
	
}
