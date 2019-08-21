package com.app.repo;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.model.Coupan;

public interface CoupanRepository extends JpaRepository<Coupan, Integer> {

	public Coupan findByCoupanCode(String code);
	
	@Query("from com.app.model.Coupan as c where c.coupanCode =:code and c.expDate >=:date ")
	public Coupan findByCoupanCodeAndExpDate(String code, Date date);
	
}
