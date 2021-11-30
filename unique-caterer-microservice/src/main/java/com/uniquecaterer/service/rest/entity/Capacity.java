package com.uniquecaterer.service.rest.entity;

import java.io.Serializable;

import javax.validation.constraints.Positive;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document
public class Capacity implements Serializable{
	
	private static final long serialVersionUID = 2315980760695022614L;

	@NonNull
	@Positive
	Integer minGuests;
	
	@NonNull
	@Positive
	Integer maxGuests;
	
	
}
