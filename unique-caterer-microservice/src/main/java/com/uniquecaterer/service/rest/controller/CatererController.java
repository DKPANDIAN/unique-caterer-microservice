package com.uniquecaterer.service.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniquecaterer.service.rest.assembler.CatererAssembler;
import com.uniquecaterer.service.rest.constant.Constants;
import com.uniquecaterer.service.rest.data.APIResponse;
import com.uniquecaterer.service.rest.data.CatererDataFactory;
import com.uniquecaterer.service.rest.data.CatererDto;
import com.uniquecaterer.service.rest.entity.Caterer;
import com.uniquecaterer.service.rest.service.CatererService;

@RestController
@RequestMapping(value = Constants.API_COMMON_ENDPOINT_PREFIX)
//@ApiOperation(value = "View a list of available resource", response = Iterable.class)
//@ApiResponses(value = {
//        @ApiResponse(code = 200, message = "Successfully retrieved list"),
//        @ApiResponse(code = 201, message = "Successfully created resource"),
//        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
public class CatererController {

	@Autowired
	CatererService catererService;

	@Autowired
	RequestBodyParamValidator requestBodyParamValidator;

	@Autowired
	CatererAssembler catererAssembler;
	
	@Autowired
	private PagedResourcesAssembler<Caterer> resourcesAssembler;
	
	@Autowired
	private CatererDataFactory catererDataFactory;
	

	@PostMapping(value = Constants.API_SAVE_CATERER_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<APIResponse> saveCatererEntity(@Valid @RequestBody CatererDto caterer) {

		ResponseEntity<APIResponse> response;
		CatererDto catererResponse = null;
		APIResponse apiResponse = new APIResponse();

		RequestBodyParamValidator.ValidationResult result = requestBodyParamValidator.validate(caterer);

		if (result.getStatusCode() == HttpStatus.ACCEPTED.value()) {
			catererResponse = catererService.saveCaterer(caterer);
		} else {
			apiResponse.setStatus(result);
			return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
		}

		if (catererResponse != null) {
			apiResponse.setCaterer(catererResponse);
			response = new ResponseEntity<APIResponse>(apiResponse, HttpStatus.CREATED);
		} else {
			apiResponse.setCaterer(catererResponse);
			response = new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;

	}

	@GetMapping(value = Constants.API_FIND_CATERER_ENDPOINT_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CatererDto> findCatererById(@PathVariable(name = "id") String id) {

		ResponseEntity<CatererDto> response;

		CatererDto catererResponse = catererService.findById(id);

		if (catererResponse != null) {
			response = new ResponseEntity<CatererDto>(catererResponse, HttpStatus.OK);
		} else {
			response = new ResponseEntity<CatererDto>(catererResponse, HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@GetMapping(value = Constants.API_FIND_CATERER_ENDPOINT_BY_NAME, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CatererDto> findCatererByName(@PathVariable(name = "name") String name) {

		ResponseEntity<CatererDto> response;

		CatererDto catererResponse = catererService.findByName(name);

		if (catererResponse != null) {
			response = new ResponseEntity<CatererDto>(catererResponse, HttpStatus.OK);
		} else {
			response = new ResponseEntity<CatererDto>(catererResponse, HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@GetMapping(value = Constants.API_FINDBYCITYNAME_CATERER_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CatererDto>> findCatererByCityName(@RequestParam(name = "cityName") String cityName,
			Pageable pageable) {

		ResponseEntity<List<CatererDto>> response;

		List<CatererDto> catererResponse = catererService.findByCityName(cityName, pageable);

		if (catererResponse != null) {
			response = new ResponseEntity<List<CatererDto>>(catererResponse, HttpStatus.OK);
		} else {
			catererResponse = new ArrayList<>();
			response = new ResponseEntity<List<CatererDto>>(catererResponse, HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@GetMapping(value = Constants.API_FINDBYCITYNAME_CATERER_ENDPOINT_PAGENATION, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PagedModel<CatererDto>> findCatererByCityNamePages(@PathVariable(name = "cityName") String cityName,
			Pageable pageable) {

		ResponseEntity<PagedModel<CatererDto>> response;
		PagedModel<CatererDto> pageModel=null;
		List<CatererDto> catererResponse = catererService.findByCityName(cityName, pageable);
		List<Caterer> catererEntities = catererDataFactory.getCatererEntities(catererResponse);
		if (catererResponse != null) { 
			
			catererAssembler.resetValues(cityName, pageable);
			Page<Caterer> page= new PageImpl<Caterer>(catererEntities);
			pageModel= resourcesAssembler.toModel(page,catererAssembler);
			response = new ResponseEntity<PagedModel<CatererDto>>(pageModel, HttpStatus.OK);
		} else {
			response = new ResponseEntity<PagedModel<CatererDto>>(pageModel, HttpStatus.NOT_FOUND);
		}

		return response;
	}

}
