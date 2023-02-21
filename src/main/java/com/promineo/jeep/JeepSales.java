package com.promineo.jeep;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.boot.SpringApplication;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})


public class JeepSales {

	public static void main (String[] args) {
		SpringApplication.run(JeepSales.class, args);
	}
}
