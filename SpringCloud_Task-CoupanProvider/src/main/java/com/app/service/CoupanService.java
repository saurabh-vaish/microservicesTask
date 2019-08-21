package com.app.service;

import java.util.List;

import com.app.model.Coupan;

public interface CoupanService {

	public Coupan saveCoupan(Coupan coupan);
	public Coupan updateCoupan(Coupan coupan);
	public Coupan getCoupanById(Integer id);
	
	public Coupan getCoupanByCode(String code);
	
	public void deleteCoupanById(Integer id);
	public List<Coupan> getAllCoupans();
	
	public boolean isExist(Integer id);
	
	public boolean isExpired(String code);
	
	
	
}
