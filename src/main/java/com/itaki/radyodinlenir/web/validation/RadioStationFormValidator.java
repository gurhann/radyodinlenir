package com.itaki.radyodinlenir.web.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.itaki.radyodinlenir.web.dto.RadioStationDTO;

@Component
public class RadioStationFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return RadioStationDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RadioStationDTO object = (RadioStationDTO) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "seoKeywords", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "seoDescription", "NotEmpty");
		if (object.getName().length() > 255) {
			errors.rejectValue("name", "MaxLength.255");
		}
		if (object.getDescription().length() > 5000) {
			errors.rejectValue("description", "MaxLength.5000");
		}
		if (object.getSeoDescription().length() > 255) {
			errors.rejectValue("seoDescription", "MaxLength.255");
		}
		if (object.getSeoKeywords().length() > 255) {
			errors.rejectValue("seoKeywords", "MaxLength.255");
		}
		if(object.getLogo().isEmpty() && object.getLogoFile().isEmpty()){
			errors.rejectValue("logoFile", "NotEmpty");
			
		}

	}

}
