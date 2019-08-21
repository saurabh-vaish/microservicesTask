package com.app.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Coupan;
import com.app.repo.CoupanRepository;
import com.app.service.CoupanService;


@Service
public class CoupanServiceImpl implements CoupanService {

	
	@Autowired
	private CoupanRepository repo;
	
	@Override
	@Transactional
	public Coupan saveCoupan(Coupan coupan) {
		return repo.save(coupan); 
	}

	
	@Override
	@Transactional
	@CachePut(value = "coupan-cache",key="#coupan.coupanId")
	public Coupan updateCoupan(Coupan coupan) {
		return repo.save(coupan);
	}

	
	
	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "coupan-cache",key="#coupanId")
	public Coupan getCoupanById(Integer coupanId) 
	{	
		Optional<Coupan> c= repo.findById(coupanId);
		return c.isPresent()?c.get():null;
	}

	
	
	@Override
	@Transactional(readOnly = true)
	public Coupan getCoupanByCode(String code) {
		return repo.findByCoupanCode(code);
	}

	
	
	@Override
	@Transactional
	@CacheEvict(value = "coupan-cache",key="#coupanId")	
	public void deleteCoupanById(Integer coupanId) {
		repo.deleteById(coupanId);
	}

	
	
	@Override
	@Transactional(readOnly = true)
	public List<Coupan> getAllCoupans() {
		return repo.findAll();
	}

	
	@Override
	public boolean isExpired(String code) {
		Coupan c= repo.findByCoupanCodeAndExpDate(code, new Date());
		return (c!=null)?true:false;
	}
	
	
	
	@Override
	public boolean isExist(Integer id) {
		System.out.println(id);
		return repo.existsById(id);
	}
	
}
