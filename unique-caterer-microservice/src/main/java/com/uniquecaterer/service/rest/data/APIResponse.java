package com.uniquecaterer.service.rest.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.uniquecaterer.service.rest.controller.RequestBodyParamValidator;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class APIResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1524528903561085226L;

	private CatererDto caterer;
	
	private RequestBodyParamValidator.ValidationResult status;
	
}
