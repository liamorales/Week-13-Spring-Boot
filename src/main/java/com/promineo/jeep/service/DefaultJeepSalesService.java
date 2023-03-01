package com.promineo.jeep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.promineotech.jeep.entity.Jeep;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j 
@Service

public class DefaultJeepSalesService implements JeepSalesService {

	
	@Override
	public List<Jeep>fetchJeeps(String model, String trim){
		log.info("the fetchJeeps method was called with model={} and trim ={}",
				model, trim);
		return null;
	}
	
}
