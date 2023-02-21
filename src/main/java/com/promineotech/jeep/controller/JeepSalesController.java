package com.promineotech.jeep.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpMethod;
import com.promineotech.jeep.entity.Jeep;


@RequestMapping("/jeeps")
@OpenAPIDefinition (info = @Info (title = "Jeep Sales Service"), servers = {
		@Server (url = "http://localhost:8080", description = "Local server.")})


public interface JeepSalesController {
	// @formatter: off
	@Operation(
			summary = "Returns a list of Jeeps ",
			description = "Returns a list of Jeeps given an optional model or trim",
			responses = {
					@ApiResponse(responseCode = "200", 
							description = "A list of jeeps is returned", 
							content = @Content(
									mediaType="applicatin/json", 
									schema = @Schema(implementation = Jeep.class))),
					@ApiResponse(responseCode = "400",
					description = "The request parameters are invalid", 
					content = @Content(mediaType="applicatin/json")),
					@ApiResponse(responseCode = "404",
					description ="No jeeps were found with the input criteria", 
					content = @Content(mediaType="applicatin/json")),
					@ApiResponse(responseCode = "500",
					description = "An unplanned error occured.", 
					content = @Content(mediaType="applicatin/json"))
			},
			parameters = {
					@Parameter(
							name = "model", 
							allowEmptyValue = false,
							required = false, 
							description = "The model name (i.e., 'WRANGLER')"),
					@Parameter(
							name = "trim", 
							allowEmptyValue = false, 
							required = false, 
							description = "The trim level (i.e., 'Sport'"),
			}
			)
	// @formatter: on 
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
List<Jeep> fetchJeeps(@RequestParam(required = false)String model, String trim);
}
