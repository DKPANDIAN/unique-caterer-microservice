package com.uniquecaterer.service.rest.entity;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;

import lombok.Data;

@Data
@Document
public class Location implements Serializable{
	
	private static final long serialVersionUID = 6149872435168241814L;

	@NonNull
	@Pattern(regexp = "^[A-Za-z0-9]*$")
	private String city;
	
	@NonNull
	private String street;
	
	@Nullable
	private String postCode;
	
}
