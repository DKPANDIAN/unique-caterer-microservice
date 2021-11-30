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
public class LocationDto extends RepresentationModel<LocationDto> implements Serializable {

	private static final long serialVersionUID = -4297434829872787536L;

	private String city;

	private String street;

	private String postCode;

}
