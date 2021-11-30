package com.uniquecaterer.service.rest.controller;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.uniquecaterer.service.rest.data.CatererDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
public class RequestBodyParamValidator {

	private static final String ALPHA_REGEX = "[a-zA-Z]+";
	private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

	public ValidationResult validate(CatererDto catererDto) {

		ValidationResult result = new ValidationResult();

		StringBuilder errMsg = new StringBuilder();

		if (catererDto == null) {
			result.setErrorMsg("\nRequest Body is required");
			result.setStatusCode(HttpStatus.BAD_REQUEST.value());
			result.setValid(false);
			return result;
		} else if (StringUtils.isEmpty(catererDto.getName())) {
			errMsg.append("\nCaterer name is required");
		}

		if (catererDto.getLocation() == null) {
			errMsg.append("\nCaterer Location is required");
		} else {

			if (StringUtils.isEmpty(catererDto.getLocation().getCity())) {
				errMsg.append("\nCaterer Location : City is required");
			} else if (!Pattern.matches(ALPHA_REGEX, catererDto.getLocation().getCity())) {
				errMsg.append("\nCaterer Location : Invalid City name");
			}

			if (StringUtils.isEmpty(catererDto.getLocation().getStreet())) {
				errMsg.append("\nCaterer Location : Street is required");
			}
		}

		if (catererDto.getCapacity() == null) {
			errMsg.append("\nCaterer Capacity is required");
		} else {

			if (catererDto.getCapacity().getMinGuests() <= 0) {
				errMsg.append("\nCaterer Capacity : Invalid Minimum number of guests");
			}

			if (catererDto.getCapacity().getMaxGuests() <= 0
					|| catererDto.getCapacity().getMaxGuests() < catererDto.getCapacity().getMinGuests()) {
				errMsg.append("\nCaterer Capacity : Invalid Maximum number of guests");
			}

		}

		if (catererDto.getContactDetails() == null) {
			errMsg.append("\nCaterer Contact Details is required");
		} else {

			if (StringUtils.isEmpty(catererDto.getContactDetails().getMobileNumber())) {
				errMsg.append("\nCaterer Contact Details: Mobilenumber is required");
			}

			if (StringUtils.isEmpty(catererDto.getContactDetails().getEmailAddress())) {
				errMsg.append("\nCaterer Contact Details: Emailaddress is required");
			} else if (Pattern.matches(EMAIL_REGEX, catererDto.getContactDetails().getEmailAddress())) {

			}
		}

		if (errMsg.length() > 0) {
			result.setErrorMsg(errMsg.toString());
			result.setStatusCode(HttpStatus.BAD_REQUEST.value());
			result.setValid(false);
		} else {
			result.setErrorMsg("");
			result.setStatusCode(HttpStatus.ACCEPTED.value());
			result.setValid(true);
		}

		return result;

	}

	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class ValidationResult {

		private boolean valid;

		private String errorMsg;

		private int statusCode;

	}
}
