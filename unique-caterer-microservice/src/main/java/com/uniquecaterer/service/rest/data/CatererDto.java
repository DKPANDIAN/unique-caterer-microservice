package com.uniquecaterer.service.rest.data;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "caterers", itemRelation = "caterer")
public class CatererDto extends RepresentationModel<CatererDto> implements Serializable{

	
	private static final long serialVersionUID = 2251721842608908748L;

	private String id;
	
	private String name;
	
	private LocationDto location;
	
	private CapacityDto capacity;
	
	private ContactDetailsDto contactDetails;
	

}
