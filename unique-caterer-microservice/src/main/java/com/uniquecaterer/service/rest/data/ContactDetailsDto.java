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
public class ContactDetailsDto extends RepresentationModel<ContactDetailsDto> implements Serializable{
	
	private static final long serialVersionUID = -6415351410336944910L;
	
	private String phoneNumber;

	private String mobileNumber;

	private String emailAddress;

}
