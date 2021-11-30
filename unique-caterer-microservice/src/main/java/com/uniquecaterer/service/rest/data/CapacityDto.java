package com.uniquecaterer.service.rest.data;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

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
public class CapacityDto extends RepresentationModel<CapacityDto> implements Serializable{

	private static final long serialVersionUID = 398147699664499659L;

	Integer minGuests;
	
	Integer maxGuests;
	
}
