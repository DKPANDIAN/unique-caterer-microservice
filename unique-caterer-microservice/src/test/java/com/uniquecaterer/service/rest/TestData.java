package com.uniquecaterer.service.rest;

import java.util.UUID;

import com.uniquecaterer.service.rest.data.CapacityDto;
import com.uniquecaterer.service.rest.data.CatererDto;
import com.uniquecaterer.service.rest.data.ContactDetailsDto;
import com.uniquecaterer.service.rest.data.LocationDto;
import com.uniquecaterer.service.rest.entity.Capacity;
import com.uniquecaterer.service.rest.entity.Caterer;
import com.uniquecaterer.service.rest.entity.ContactDetails;
import com.uniquecaterer.service.rest.entity.Location;

public class TestData {
	
	
	/*
	 * Entities
	 * 
	 */
	public static Caterer TEST_DATA_CATERER_1=new Caterer();
	public static Caterer TEST_DATA_CATERER_2=new Caterer();
	public static Caterer TEST_DATA_CATERER_3=new Caterer();
	
	public static Capacity TEST_DATA_CAPACITY_1= new Capacity();
	public static Capacity TEST_DATA_CAPACITY_2= new Capacity();
	public static Capacity TEST_DATA_CAPACITY_3= new Capacity();
	
	public static Location TEST_DATA_LOCATION_1= new Location();
	public static Location TEST_DATA_LOCATION_2= new Location();
	public static Location TEST_DATA_LOCATION_3= new Location();
	
	public static ContactDetails TEST_DATA_CONTACT_1= new ContactDetails();
	public static ContactDetails TEST_DATA_CONTACT_2= new ContactDetails();
	public static ContactDetails TEST_DATA_CONTACT_3= new ContactDetails();

	/*
	 * Webmode / Dto
	 * 
	 */
	
	public static final CatererDto TEST_DATA_CATERER_DTO_1=new CatererDto();
	public static final CatererDto TEST_DATA_CATERER_DTO_2=new CatererDto();
	public static final CatererDto TEST_DATA_CATERER_DTO_3=new CatererDto();
	
	public static final CapacityDto TEST_DATA_CAPACITY_DTO_1= new CapacityDto();
	public static final CapacityDto TEST_DATA_CAPACITY_DTO_2= new CapacityDto();
	public static final CapacityDto TEST_DATA_CAPACITY_DTO_3= new CapacityDto();

	public static final LocationDto TEST_DATA_LOCATION_DTO_1= new LocationDto();
	public static final LocationDto TEST_DATA_LOCATION_DTO_2= new LocationDto();
	public static final LocationDto TEST_DATA_LOCATION_DTO_3= new LocationDto();
	
	public static final ContactDetailsDto TEST_DATA_CONTACT_DTO_1= new ContactDetailsDto();
	public static final ContactDetailsDto TEST_DATA_CONTACT_DTO_2= new ContactDetailsDto();
	public static final ContactDetailsDto TEST_DATA_CONTACT_DTO_3= new ContactDetailsDto();
	
	public static final String TEST_DATA_ID_1="f12f17c5-b071-49ab-a027-19a0841d61b8";
	public static final String TEST_DATA_ID_2=UUID.randomUUID().toString();
	public static final String TEST_DATA_ID_3=UUID.randomUUID().toString();
	
	static {
		
		TEST_DATA_CAPACITY_1.setMaxGuests(3);
		TEST_DATA_CAPACITY_1.setMinGuests(1);
		
		TEST_DATA_CAPACITY_2.setMaxGuests(1);
		TEST_DATA_CAPACITY_2.setMinGuests(1);

		TEST_DATA_CAPACITY_3.setMaxGuests(1);
		TEST_DATA_CAPACITY_3.setMinGuests(3);
		
		TEST_DATA_CAPACITY_DTO_1.setMaxGuests(3);
		TEST_DATA_CAPACITY_DTO_1.setMinGuests(1);
		
		TEST_DATA_CAPACITY_DTO_2.setMaxGuests(1);
		TEST_DATA_CAPACITY_DTO_2.setMinGuests(1);

		TEST_DATA_CAPACITY_DTO_3.setMaxGuests(1);
		TEST_DATA_CAPACITY_DTO_3.setMinGuests(3);

		TEST_DATA_LOCATION_1.setCity("TEST-CITY-1");
		TEST_DATA_LOCATION_1.setPostCode("TEST-CODE-1001");
		TEST_DATA_LOCATION_1.setStreet("TEST-STREET-1");
		
		TEST_DATA_LOCATION_2.setCity("TEST-CITY-2");
		TEST_DATA_LOCATION_2.setPostCode("TEST-CODE-1002");
		TEST_DATA_LOCATION_2.setStreet(null);
		
		TEST_DATA_LOCATION_DTO_1.setCity("TEST-CITY-1");
		TEST_DATA_LOCATION_DTO_1.setPostCode("TEST-CODE-1001");
		TEST_DATA_LOCATION_DTO_1.setStreet("TEST-STREET-1");
		
		TEST_DATA_LOCATION_DTO_2.setCity("TEST-CITY-2");
		TEST_DATA_LOCATION_DTO_2.setPostCode("TEST-CODE-1002");
		TEST_DATA_LOCATION_DTO_2.setStreet(null);
		
		
		TEST_DATA_CONTACT_1.setEmailAddress("abc@test.com");
		TEST_DATA_CONTACT_1.setMobileNumber("10987654321");
		TEST_DATA_CONTACT_1.setPhoneNumber("01-98765");
		
		TEST_DATA_CONTACT_DTO_1.setEmailAddress("abc@test.com");
		TEST_DATA_CONTACT_DTO_1.setMobileNumber("10987654321");
		TEST_DATA_CONTACT_DTO_1.setPhoneNumber("01-98765");
		
		TEST_DATA_CONTACT_2.setEmailAddress("abc@test.com");
		TEST_DATA_CONTACT_2.setMobileNumber("10987654321");
		TEST_DATA_CONTACT_2.setPhoneNumber(null);
		
		TEST_DATA_CONTACT_DTO_2.setEmailAddress("abc@test.com");
		TEST_DATA_CONTACT_DTO_2.setMobileNumber("10987654321");
		TEST_DATA_CONTACT_DTO_2.setPhoneNumber(null);
		
		/*
		 * ENTITY TEST DATA 
		 */
		
		TEST_DATA_CATERER_1.setCapacity(TEST_DATA_CAPACITY_1);
		TEST_DATA_CATERER_1.setContactDetails(TEST_DATA_CONTACT_1);
		TEST_DATA_CATERER_1.setLocation(TEST_DATA_LOCATION_1);
		TEST_DATA_CATERER_1.setId(TEST_DATA_ID_1);
		TEST_DATA_CATERER_1.setName("TEST DATA 1");
		
		TEST_DATA_CATERER_2.setCapacity(TEST_DATA_CAPACITY_2);
		TEST_DATA_CATERER_2.setContactDetails(TEST_DATA_CONTACT_2);
		TEST_DATA_CATERER_2.setLocation(TEST_DATA_LOCATION_2);
		TEST_DATA_CATERER_2.setId(TEST_DATA_ID_2);
		TEST_DATA_CATERER_2.setName("TEST DATA 2");
		
		TEST_DATA_CATERER_3.setCapacity(TEST_DATA_CAPACITY_3);
		TEST_DATA_CATERER_3.setContactDetails(TEST_DATA_CONTACT_3);
		TEST_DATA_CATERER_3.setLocation(TEST_DATA_LOCATION_3);
		TEST_DATA_CATERER_3.setId(TEST_DATA_ID_3);
		TEST_DATA_CATERER_3.setName("TEST DATA 3");
		
		
		TEST_DATA_CATERER_DTO_1.setCapacity(TEST_DATA_CAPACITY_DTO_1);
		TEST_DATA_CATERER_DTO_1.setContactDetails(TEST_DATA_CONTACT_DTO_1);
		TEST_DATA_CATERER_DTO_1.setLocation(TEST_DATA_LOCATION_DTO_1);
		TEST_DATA_CATERER_DTO_1.setId(TEST_DATA_ID_1);
		TEST_DATA_CATERER_DTO_1.setName("TEST DATA 1");
		
		TEST_DATA_CATERER_DTO_1.setCapacity(TEST_DATA_CAPACITY_DTO_2);
		TEST_DATA_CATERER_DTO_1.setContactDetails(TEST_DATA_CONTACT_DTO_2);
		TEST_DATA_CATERER_DTO_1.setLocation(TEST_DATA_LOCATION_DTO_2);
		TEST_DATA_CATERER_DTO_1.setId(TEST_DATA_ID_2);
		TEST_DATA_CATERER_DTO_1.setName("TEST DATA 2");
		
		TEST_DATA_CATERER_DTO_1.setCapacity(TEST_DATA_CAPACITY_DTO_3);
		TEST_DATA_CATERER_DTO_1.setContactDetails(TEST_DATA_CONTACT_DTO_3);
		TEST_DATA_CATERER_DTO_1.setLocation(TEST_DATA_LOCATION_DTO_3);
		TEST_DATA_CATERER_DTO_1.setId(TEST_DATA_ID_3);
		TEST_DATA_CATERER_DTO_1.setName("TEST DATA 3");
	}
	
	

}
