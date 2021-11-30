package com.uniquecaterer.service.rest.data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class CatererEvent implements Serializable{

	private static final long serialVersionUID = -391401328006422508L;

	private UUID eventId;
	
	private CatererDto object;
	
	private Date timestamp;
		
	private String eventType;
	
}
