package com.uniquecaterer.service.rest.entity;

import java.io.Serializable;

import javax.validation.constraints.Email;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;

import lombok.Data;

@Data
@Document
public class ContactDetails implements Serializable{

	private static final long serialVersionUID = -6196397921758936220L;
	
	@Nullable
	private String phoneNumber;
	
	@NonNull
	private String mobileNumber;
	
	@NonNull
	@Email
	private String emailAddress;
	
}
