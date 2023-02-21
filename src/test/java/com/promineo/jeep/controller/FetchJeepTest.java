package com.promineo.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import com.promineo.jeep.controller.support.FetchJeepTestSupport;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {
		"classpath:flyway/migrations/V1.0_Jeep_Schema.sql",
		"classpath:flyway/migrations/V1.1_Jeep_Data.sql"},
	config = @SqlConfig(encoding = "utf-8"))

class FetchJeepTest extends FetchJeepTestSupport{
	
	@Autowired
	private JdbcTemplate jbdcTemplate;
	
	@Test
	void testDb() {
		int numrows = JbdcTestUtils.countRowsInTable(jbdcTemplate, "customers");
		System.out.println("num" + numrows);
	}

	@Test
	void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
		fail("Not yet implemented");
		//Given : a valid model, trim and URI
		JeepModel model = JeepModel.WRANGLER;
		String trim = "Sport";
		String uri = String.format("http://localhost:%d/jeeps?model=%s&trim=%s", serverPort, model, trim);
		
		//When: a connection is made to the URI
		ResponseEntity<List<Jeep>>response = 
				getRestTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {} );
		//Then: a success (OK - 200) is returned
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		//And : the actual list returned is the same as the expected list
		
	 List<Jeep> expected = buildExpected();
	}

	protected List<Jeep> buildExpected() {
		assertThat(response.getBody()).isEqualTo(expected);
		return null;
	}

	
}
