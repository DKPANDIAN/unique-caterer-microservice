package com.uniquecaterer.service.rest.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.uniquecaterer.service.rest.TestConfig;
import com.uniquecaterer.service.rest.TestData;
import com.uniquecaterer.service.rest.constant.Constants;
import com.uniquecaterer.service.rest.data.CatererDto;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.yml")
@Import(TestConfig.class)
public class CatererAPITIntegTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private JsonMapper jsonMapper;

	@Test
	public void givenEntityToSaveCatererEntityReturnResult200() throws Exception {
		
		CatererDto catererRequest = TestData.TEST_DATA_CATERER_DTO_1;
		TestData.TEST_DATA_LOCATION_DTO_1.setCity("TESTCITY");
		catererRequest.setId(null);
		catererRequest.setName("Test-Intg-Caterer");
		catererRequest.setLocation(TestData.TEST_DATA_LOCATION_DTO_1);
		catererRequest.setCapacity(TestData.TEST_DATA_CAPACITY_DTO_1);
		catererRequest.setContactDetails(TestData.TEST_DATA_CONTACT_DTO_1);
		
		String requestBody = jsonMapper.writeValueAsString(catererRequest);
		
		MockHttpServletResponse response = mvc
				.perform(post(Constants.API_COMMON_ENDPOINT_PREFIX+Constants.API_SAVE_CATERER_ENDPOINT)
				 .contentType(MediaType.APPLICATION_JSON)
				 .content(requestBody))
				.andReturn().getResponse();

		assertEquals(201,response.getStatus());
		
	}
	
	@Test
	public void givenEntityToSaveCatererEntityReturnResultBadrequest400() throws Exception {
		
		CatererDto catererRequest = TestData.TEST_DATA_CATERER_DTO_1;
		TestData.TEST_DATA_LOCATION_DTO_1.setCity("TESTCITY 11");
		catererRequest.setId(null);
		catererRequest.setName("Test-Intg-Caterer");
		catererRequest.setLocation(TestData.TEST_DATA_LOCATION_DTO_1);
		catererRequest.setCapacity(TestData.TEST_DATA_CAPACITY_DTO_1);
		catererRequest.setContactDetails(TestData.TEST_DATA_CONTACT_DTO_1);
		
		String requestBody = jsonMapper.writeValueAsString(catererRequest);
		
		MockHttpServletResponse response = mvc
				.perform(post(Constants.API_COMMON_ENDPOINT_PREFIX+Constants.API_SAVE_CATERER_ENDPOINT)
				 .contentType(MediaType.APPLICATION_JSON)
				 .content(requestBody))
				.andReturn().getResponse();

		assertEquals(400,response.getStatus());
		
	}
	
	@Test
	public void givenEntityToSaveCatererCapacityEmptyReturnResultBadrequest400() throws Exception {
		
		CatererDto catererRequest = TestData.TEST_DATA_CATERER_DTO_1;
		TestData.TEST_DATA_LOCATION_DTO_1.setCity("TESTCITY 11");
		catererRequest.setId(null);
		catererRequest.setName("Test-Intg-Caterer2");
		catererRequest.setLocation(TestData.TEST_DATA_LOCATION_DTO_1);
		catererRequest.setCapacity(null);
		catererRequest.setContactDetails(TestData.TEST_DATA_CONTACT_DTO_1);
		
		String requestBody = jsonMapper.writeValueAsString(catererRequest);
		
		MockHttpServletResponse response = mvc
				.perform(post(Constants.API_COMMON_ENDPOINT_PREFIX+Constants.API_SAVE_CATERER_ENDPOINT)
				 .contentType(MediaType.APPLICATION_JSON)
				 .content(requestBody))
				.andReturn().getResponse();

		assertEquals(400,response.getStatus());
		
	}
	
	@Test
	public void givenEntityToSaveCatererLocationEmptyReturnResultBadrequest400() throws Exception {
		
		CatererDto catererRequest = TestData.TEST_DATA_CATERER_DTO_1;
		TestData.TEST_DATA_LOCATION_DTO_1.setCity("TESTCITY 11");
		catererRequest.setId(null);
		catererRequest.setName("Test-Intg-Caterer3");
		catererRequest.setLocation(null);
		catererRequest.setCapacity(null);
		catererRequest.setContactDetails(TestData.TEST_DATA_CONTACT_DTO_1);
		
		String requestBody = jsonMapper.writeValueAsString(catererRequest);
		
		MockHttpServletResponse response = mvc
				.perform(post(Constants.API_COMMON_ENDPOINT_PREFIX+Constants.API_SAVE_CATERER_ENDPOINT)
				 .contentType(MediaType.APPLICATION_JSON)
				 .content(requestBody))
				.andReturn().getResponse();

		assertEquals(400,response.getStatus());
		
	}
	
	@Test
	public void givenEntityToSaveCatererContactDetailsEmptyReturnResultBadrequest400() throws Exception {
		
		CatererDto catererRequest = TestData.TEST_DATA_CATERER_DTO_1;
		TestData.TEST_DATA_LOCATION_DTO_1.setCity("TESTCITY 11");
		catererRequest.setId(null);
		catererRequest.setName("Test-Intg-Caterer");
		catererRequest.setLocation(TestData.TEST_DATA_LOCATION_DTO_1);
		catererRequest.setCapacity(null);
		catererRequest.setContactDetails(null);
		
		String requestBody = jsonMapper.writeValueAsString(catererRequest);
		
		MockHttpServletResponse response = mvc
				.perform(post(Constants.API_COMMON_ENDPOINT_PREFIX+Constants.API_SAVE_CATERER_ENDPOINT)
				 .contentType(MediaType.APPLICATION_JSON)
				 .content(requestBody))
				.andReturn().getResponse();

		assertEquals(400,response.getStatus());
		
	}
	
	
	@Test
	public void givenIdtoResourceReturen200() throws Exception {
		
		String id = TestData.TEST_DATA_ID_1;
		
		MockHttpServletResponse response = mvc
				.perform(get(Constants.API_COMMON_ENDPOINT_PREFIX+Constants.API_FIND_CATERER_ENDPOINT_BY_ID,id)
				 .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		assertEquals(200,response.getStatus());
		
	}
	
	@Test
	public void givenIdtoResourceUnknownReturen404() throws Exception {
		
		String id = "randomid-1213";
		
		MockHttpServletResponse response = mvc
				.perform(get(Constants.API_COMMON_ENDPOINT_PREFIX+Constants.API_FIND_CATERER_ENDPOINT_BY_ID,id)
				 .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		assertEquals(404,response.getStatus());
		
	}
	
	@Test
	public void givenNametoResourceReturen200() throws Exception {
		
		String name = TestData.TEST_DATA_CATERER_1.getName();
		
		MockHttpServletResponse response = mvc
				.perform(get(Constants.API_COMMON_ENDPOINT_PREFIX+Constants.API_FIND_CATERER_ENDPOINT_BY_NAME,name)
				 .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		assertEquals(200,response.getStatus());
		
	}
	
	@Test
	public void givenNametoResourceUnknownReturen404() throws Exception {
		
		String name = "random-name";
			
		MockHttpServletResponse response = mvc
				.perform(get(Constants.API_COMMON_ENDPOINT_PREFIX+Constants.API_FIND_CATERER_ENDPOINT_BY_NAME,name)
				 .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		assertEquals(404,response.getStatus());
		
	}
	
	@Test
	public void givenCityNametoResourceUnknownReturen404() throws Exception {
		
		String name = "randomid-1213";
		
		MockHttpServletResponse response = mvc
				.perform(get(Constants.API_COMMON_ENDPOINT_PREFIX+Constants.API_FINDBYCITYNAME_CATERER_ENDPOINT_PAGENATION,name)
				 .contentType(MediaType.APPLICATION_JSON)
				 .requestAttr("page", "0")
				 .requestAttr("size", "0"))
				.andReturn().getResponse();
		assertEquals(404,response.getStatus());
		
	}
	
	@Test
	public void givenCityNametoResourceAvailableReturen200() throws Exception {
		
				
		MockHttpServletResponse response = mvc
				.perform(get(Constants.API_COMMON_ENDPOINT_PREFIX+Constants.API_FINDBYCITYNAME_CATERER_ENDPOINT_PAGENATION,TestData.TEST_DATA_CATERER_1.getLocation().getCity())
				 .contentType(MediaType.APPLICATION_JSON)
				 .requestAttr("page", "0")
				 .requestAttr("size", "1"))
				.andReturn().getResponse();
		assertEquals(200,response.getStatus());
		assertNotNull(response.getContentAsString());
		
	}
	
	
	@Test
	public void givenCityNametoResourceInvalidPageReturen404() throws Exception {
		
				
		MockHttpServletResponse response = mvc
				.perform(get(Constants.API_COMMON_ENDPOINT_PREFIX+Constants.API_FINDBYCITYNAME_CATERER_ENDPOINT_PAGENATION,"empty")
				 .contentType(MediaType.APPLICATION_JSON)
				 .requestAttr("page", "0")
				 .requestAttr("size", "1"))
				.andReturn().getResponse();
		assertEquals(404,response.getStatus());
		
	}
	
	@Test
	public void givenCityNametoResourceInvalidSizeReturen404() throws Exception {
		
				
		MockHttpServletResponse response = mvc
				.perform(get(Constants.API_COMMON_ENDPOINT_PREFIX+Constants.API_FINDBYCITYNAME_CATERER_ENDPOINT_PAGENATION,"empty")
				 .contentType(MediaType.APPLICATION_JSON)
				 .requestAttr("page", "10")
				 .requestAttr("size", "1"))
				.andReturn().getResponse();
		assertEquals(404,response.getStatus());
		
	}
	
	
}


