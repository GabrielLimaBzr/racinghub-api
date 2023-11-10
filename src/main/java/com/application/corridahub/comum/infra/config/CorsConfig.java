package com.application.corridahub.comum.infra.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{
	
	@Value("${app.cors-origin}")
	private String corsOrigin;  

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins(corsOrigin)
			.allowedMethods("*")
			.allowedHeaders("*");
	}

}
