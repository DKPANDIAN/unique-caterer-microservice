package com.uniquecaterer.service.rest.data;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.uniquecaterer.service.rest.constant.Constants;
import com.uniquecaterer.service.rest.entity.Capacity;
import com.uniquecaterer.service.rest.entity.Caterer;
import com.uniquecaterer.service.rest.entity.ContactDetails;
import com.uniquecaterer.service.rest.entity.Location;

@Component
public class CatererDataFactory {

	@Autowired
	private JsonMapper jsonMapper;

	private static final Logger logger = LoggerFactory.getLogger(CatererDataFactory.class);

	public Caterer getCatererEntity(CatererDto catererDto) {

		if (catererDto != null) {
			Caterer caterer = new Caterer();
			Location location = new Location();
			ContactDetails contact = new ContactDetails();
			Capacity capacity = new Capacity();

			caterer.setName(catererDto.getName());
			caterer.setId(catererDto.getId());

			if (catererDto.getLocation() != null) {
				location.setCity(catererDto.getLocation().getCity());
				location.setStreet(catererDto.getLocation().getStreet());
				location.setPostCode(catererDto.getLocation().getPostCode());
			}

			if (catererDto.getCapacity() != null) {
				capacity.setMinGuests(catererDto.getCapacity().getMinGuests());
				capacity.setMaxGuests(catererDto.getCapacity().getMaxGuests());
			}

			if (catererDto.getContactDetails() != null) {
				contact.setPhoneNumber(catererDto.getContactDetails().getPhoneNumber());
				contact.setMobileNumber(catererDto.getContactDetails().getMobileNumber());
				contact.setEmailAddress(catererDto.getContactDetails().getEmailAddress());
			}

			caterer.setLocation(location);
			caterer.setContactDetails(contact);
			caterer.setCapacity(capacity);
			return caterer;
		}

		return null;
	}

	public CatererDto getCatererDto(Caterer caterer) {

		if (caterer != null) {
			CatererDto catererDto = new CatererDto();
			LocationDto location = new LocationDto();
			ContactDetailsDto contact = new ContactDetailsDto();
			CapacityDto capacity = new CapacityDto();

			catererDto.setName(caterer.getName());
			catererDto.setId(caterer.getId());
			
			if (caterer.getLocation() != null) {
				location.setCity(caterer.getLocation().getCity());
				location.setStreet(caterer.getLocation().getStreet());
				location.setPostCode(caterer.getLocation().getPostCode());
			}

			if (caterer.getCapacity() != null) {
				capacity.setMinGuests(caterer.getCapacity().getMinGuests());
				capacity.setMaxGuests(caterer.getCapacity().getMaxGuests());
			}

			if (caterer.getContactDetails() != null) {
				contact.setPhoneNumber(caterer.getContactDetails().getPhoneNumber());
				contact.setMobileNumber(caterer.getContactDetails().getMobileNumber());
				contact.setEmailAddress(caterer.getContactDetails().getEmailAddress());
			}

			catererDto.setLocation(location);
			catererDto.setContactDetails(contact);
			catererDto.setCapacity(capacity);
			return catererDto;
		}

		return null;
	}
	
	public List<Caterer> getCatererEntities(List<CatererDto> dtos) {
		List<Caterer> caters= null;
		if (!CollectionUtils.isEmpty(dtos)) {
			
			caters=dtos.stream().map(dto->{
				return getCatererEntity(dto);
			}).collect(Collectors.toList());
		}
		
		return caters;
	}
	
	
	public String getNewEvent(CatererDto catererDto) {
		
		CatererEvent catererEvent =  new CatererEvent();
		String msg=null;
		if (catererDto!=null) {
			
			catererEvent.setEventId(UUID.randomUUID());
			catererEvent.setEventType(Constants.EVENT_TYPE_NEW);
			catererEvent.setObject(catererDto);
			catererEvent.setTimestamp(Calendar.getInstance().getTime());
			
			try {
				msg=jsonMapper.writeValueAsString(catererEvent);
			} catch (JsonProcessingException e) {
				logger.error("CatererDataFactory::getNewEvent() failed with exception {}  ",e.getMessage());
			}
			
		}
		
		return msg;
		
	}
}
