package com.devsuperior.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//configura e cria uma instancia de rest Template:
@Configuration
public class AppConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
