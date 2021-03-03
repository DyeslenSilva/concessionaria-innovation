package com.concessionaria.innovation.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

public class WebMvcConfig {


	private final long MAX_AGE_SECS = 3600;

	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("HEAD", "OPTIONS",  "PATCH", "GET", "PUT", "POST", "DELETE")
			.maxAge(MAX_AGE_SECS);
	}
}
