package com.uniquecaterer.service.rest.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.uniquecaterer.service.rest.TestData;

@RunWith(SpringRunner.class)
public class CatererDataDtoModelEntityMapperTest {

	@Test
	public void testCatererEntity() {
		
		assertEquals(TestData.TEST_DATA_CAPACITY_1.getMinGuests(), TestData.TEST_DATA_CAPACITY_DTO_1.getMinGuests());
		assertEquals(TestData.TEST_DATA_CAPACITY_1.getMaxGuests(), TestData.TEST_DATA_CAPACITY_DTO_1.getMaxGuests());
		
		assertEquals(TestData.TEST_DATA_CAPACITY_1.getMinGuests(), TestData.TEST_DATA_CAPACITY_DTO_1.getMinGuests());
		
		assertEquals(TestData.TEST_DATA_CONTACT_1.getEmailAddress(), TestData.TEST_DATA_CONTACT_DTO_1.getEmailAddress());
		assertEquals(TestData.TEST_DATA_CONTACT_1.getMobileNumber(), TestData.TEST_DATA_CONTACT_DTO_1.getMobileNumber());
		
	
	}
	
		
	
}
