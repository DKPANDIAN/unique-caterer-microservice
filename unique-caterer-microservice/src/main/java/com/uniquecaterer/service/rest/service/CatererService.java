package com.uniquecaterer.service.rest.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.uniquecaterer.service.rest.data.CatererDto;

public interface CatererService {

	public CatererDto saveCaterer(CatererDto catererDto);
	
	public CatererDto findById(String id);
	
	public CatererDto findByName(String name);
	
	public List<CatererDto> findByCityName(String cityName,Pageable pageable);
	public List<CatererDto> findByCityName(String cityName);
	
}
