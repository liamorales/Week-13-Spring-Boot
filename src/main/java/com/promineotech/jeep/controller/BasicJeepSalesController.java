package com.promineotech.jeep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineo.jeep.service.JeepSalesService;
import com.promineotech.jeep.entity.Jeep;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class BasicJeepSalesController implements JeepSalesController {

	@Autowired
	private JeepSalesService jeepSalesService;
	@Override
	public List<Jeep> fetchJeeps(String model, String trim) {
		Log.debug("model = {} , trimm = {}", model, trim);
		return jeepSalesService.fetchJeeps(model, trim);
	}

}
