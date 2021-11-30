package com.uniquecaterer.service.rest.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document
public class Caterer implements Serializable{

	private static final long serialVersionUID = -1651282054842925097L;

	@Id
	private String id;
	
	@NonNull
	@Indexed(unique = true)
	private String name;
	
	@NonNull
	private Location location;
	
	@NonNull 
	private Capacity capacity;
	
	@NonNull
	private ContactDetails contactDetails;
	

}
