package com.promineo.jeep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineo.jeep.dao.JeepSalesDao;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

@Slf4j 
@Service

public class DefaultJeepSalesService implements JeepSalesService {

	@Autowired
	private JeepSalesDao jeepSalesDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Jeep>fetchJeeps(JeepModel model, String trim){
		log.info("the fetchJeeps method was called with model={} and trim ={}",
				model, trim);
		
		
	List<Jeep> jeeps = jeepSalesDao.fetchJeeps(model, trim);
	
	Collections.sort(jeeps);
	return jeeps;
	}
	
}
