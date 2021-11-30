package com.uniquecaterer.service.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.uniquecaterer.service.rest.assembler.CatererAssembler;
import com.uniquecaterer.service.rest.controller.CatererController;
import com.uniquecaterer.service.rest.data.CatererDataFactory;
import com.uniquecaterer.service.rest.data.CatererDto;

@Configuration
public class TestConfig {

	
//	@Bean
//	public JsonMapper jsonMapper() {
//		return new JsonMapper();
//	}
	
	@Bean
	public CatererDataFactory catererDataFactory () {
		return new CatererDataFactory();
	}
	@Bean
	public CatererAssembler catererAssembler() {
		return new CatererAssembler(CatererController.class, CatererDto.class);
	}
}
