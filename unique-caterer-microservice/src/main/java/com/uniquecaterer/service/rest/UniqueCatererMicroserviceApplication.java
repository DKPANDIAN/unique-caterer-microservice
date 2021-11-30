package com.uniquecaterer.service.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.uniquecaterer.service.rest.assembler.CatererAssembler;
import com.uniquecaterer.service.rest.controller.CatererController;
import com.uniquecaterer.service.rest.data.CatererDto;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSpringDataWebSupport
@EnableMongoRepositories(basePackages={"com.uniquecaterer.service.rest.repo"})
@EnableCaching

public class UniqueCatererMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniqueCatererMicroserviceApplication.class, args);
	}
	
	@Bean
	public JsonMapper jsonMapper() {
		return new JsonMapper();
	}
	
	@Bean
	public CatererAssembler catererAssembler() {
		return new CatererAssembler(CatererController.class, CatererDto.class);
	}
}
