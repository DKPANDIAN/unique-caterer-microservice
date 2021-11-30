package com.uniquecaterer.service.rest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.UUID;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.uniquecaterer.service.rest.data.CatererDto;
import com.uniquecaterer.service.rest.entity.Caterer;
import com.uniquecaterer.service.rest.repo.CatererRepository;
import com.uniquecaterer.service.rest.service.CatererService;

@SpringBootTest
@Import(TestConfig.class)
@ComponentScan(basePackages = {"com.uniquecaterer.service.rest"})
@EnableAutoConfiguration
class UniqueCatererMicroserviceApplicationTests {
	

	@Autowired
	CatererService catererService;
	
	@Autowired
	CatererRepository catererRepository;
	
	@Before
	public void addRecords() {
		catererRepository.save(TestData.TEST_DATA_CATERER_1);
		catererRepository.save(TestData.TEST_DATA_CATERER_2);
		catererRepository.save(TestData.TEST_DATA_CATERER_3);
	}

	@Test
	public void testFindLocationCityNameEntity() {

		List<Caterer> caterer=catererRepository.findByLocationCityName(TestData.TEST_DATA_LOCATION_1.getCity());
		assertNotNull(caterer);
		assertNotNull(caterer.get(0).getLocation().getCity());
		assertEquals(TestData.TEST_DATA_LOCATION_1.getCity(), caterer.get(0).getLocation().getCity());
	}
	
	@Test
	public void testFindLocationCityName_not_found() {

		List<Caterer> caterer=catererRepository.findByLocationCityName("NO CITY");
		assertTrue(CollectionUtils.isEmpty(caterer));
	}
	
	@Test
	public void testFindLocationCityNameEntityPages() {
	
		Pageable pageable = PageRequest.of(0, 1);
		Page<Caterer> caterer=catererRepository.findByLocationCity(TestData.TEST_DATA_LOCATION_1.getCity(),pageable);

		assertNotNull(caterer);
		assertNotNull(caterer.getContent().get(0).getLocation().getCity());
		assertEquals(1,caterer.getContent().size());
		assertEquals(TestData.TEST_DATA_LOCATION_1.getCity(), caterer.getContent().get(0).getLocation().getCity());
	}
	
	@Test
	public void testFindLocationCityNameEntityPages_not_found() {

		Pageable pageable = PageRequest.of(0, 1);
		Page<Caterer> caterer=catererRepository.findByLocationCity("NO CITY",pageable);
		assertTrue(caterer.isEmpty());
	}
	
	@Test
	public void test_find_byName_found() {
		Caterer caterer=catererRepository.findByName(TestData.TEST_DATA_CATERER_1.getName());
		assertNotNull(caterer);
		assertEquals(caterer.getName(), TestData.TEST_DATA_CATERER_1.getName());
	}
	
	@Test
	public void test_find_byName_not_found() {
		Caterer caterer=catererRepository.findByName("NO NAME");
		assertNull(caterer);
		
	}

	@Test
	void contextLoads() {
		assertNotNull(catererService);
		assertNotNull(catererService);
	}
	
	@Test
	public void testSaveCatererOK() {
		
		CatererDto testDto=TestData.TEST_DATA_CATERER_DTO_1;
		testDto.setName(UUID.randomUUID().toString());
		testDto.setLocation(TestData.TEST_DATA_LOCATION_DTO_1);
		testDto.getLocation().setCity("NEW CITY");
		CatererDto caterer = catererService.saveCaterer(testDto);
		assertNotNull(caterer);
		assertEquals("NEW CITY", caterer.getLocation().getCity());
	}
	
	
	@Test
	public void testSaveCatererNOK() {
		
		CatererDto testDto=null;
		CatererDto caterer = catererService.saveCaterer(testDto);
		assertNull(caterer);
		
	}
	
	@Test
	public void testFindByIdCatererFound() {
		CatererDto caterer = catererService.findById("f12f17c5-b071-49ab-a027-19a0841d61b8");
		assertNotNull(caterer);
	}
	
	@Test
	public void testFindByIdCatererNotFound() {
		CatererDto caterer = catererService.findById(UUID.randomUUID().toString());
		assertNull(caterer);
	}
	
	@Test
	public void testFindByNameFound() {
		CatererDto caterer = catererService.findByName(TestData.TEST_DATA_CATERER_1.getName());
		assertNotNull(caterer);
	}
	
	@Test
	public void testFindByNameNotFound() {
		CatererDto caterer = catererService.findByName("NO NAME");
		assertNull(caterer);
	}
	
	@Test 
	public void testFindByCityNameFound() {
		List<CatererDto> caterer = catererService.findByCityName("TEST-CITY-2");
		assertTrue(CollectionUtils.isNotEmpty(caterer));
	}
	
	@Test 
	public void testFindByCityNameNotFound() {
		List<CatererDto> caterer = catererService.findByCityName("TEST-CITY-NA");
		assertFalse(CollectionUtils.isNotEmpty(caterer));
	}
	
	@Test 
	public void testFindByCityNamePageableFound() {
		Pageable pageable = PageRequest.of(0, 1);
		List<CatererDto> caterer = catererService.findByCityName("TEST-CITY-2",pageable);
		assertTrue(CollectionUtils.isNotEmpty(caterer));
	}
	
	@Test 
	public void testFindByCityNamePageableNotFound() {
		Pageable pageable = PageRequest.of(5, 6);
		List<CatererDto> caterer = catererService.findByCityName("TEST-CITY-2",pageable);
		assertFalse(CollectionUtils.isNotEmpty(caterer));
	}
	
	
}
