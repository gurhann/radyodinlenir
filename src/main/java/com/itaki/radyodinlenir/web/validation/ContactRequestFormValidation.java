package com.itaki.radyodinlenir.web.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.itaki.radyodinlenir.web.dto.ContactRequestDTO;

@Component
public class ContactRequestFormValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ContactRequestDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ContactRequestDTO contactRequest = (ContactRequestDTO) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
		if (contactRequest.getName().length() > 100) {
			errors.rejectValue("name", "MaxLength.100");
		}
		if (contactRequest.getMessage().length() > 500) {
			errors.rejectValue("message", "MaxLength.500");
		}
		if (contactRequest.getSecurity() != 21) {
			errors.rejectValue("security", "Security.Error");
		}
		if (contactRequest.getEmail().length() > 100) {
			errors.rejectValue("email", "MaxLength.100");
		}
	}

}
