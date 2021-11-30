package com.uniquecaterer.service.rest.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.uniquecaterer.service.rest.controller.CatererController;
import com.uniquecaterer.service.rest.data.CatererDataFactory;
import com.uniquecaterer.service.rest.data.CatererDto;
import com.uniquecaterer.service.rest.entity.Caterer;

public class CatererAssembler extends RepresentationModelAssemblerSupport<Caterer,CatererDto>{
	
	@Autowired
	CatererDataFactory catererDataFactory;
	
	private String cityName=null;;
	
	private Pageable pageable=null;
	
//	@PostConstruct
//	private void init() {
//		catererDataFactory = new CatererDataFactory();
//	}
	
	public void resetValues(String cityName,Pageable pageable) {
		this.cityName=cityName;
		this.pageable=pageable;
	}
 	

	public CatererAssembler(Class<?> controllerClass, Class<CatererDto> resourceType) {
		super(CatererController.class, CatererDto.class);
	}

	@Override
	public CatererDto toModel(Caterer entity) {
		
		CatererDto dto=catererDataFactory.getCatererDto(entity);
		
		dto.add(linkTo(methodOn(CatererController.class).findCatererById(entity.getId())).withSelfRel());

		return dto;
	}
	
	@Override
	public CollectionModel<CatererDto> toCollectionModel(Iterable<? extends Caterer> entities) {
		
		CollectionModel<CatererDto> dtos=super.toCollectionModel(entities);
		
		dtos.add(linkTo(methodOn(CatererController.class).findCatererByCityName(cityName, pageable)).withSelfRel());
		
		return dtos;
	
	}

}
