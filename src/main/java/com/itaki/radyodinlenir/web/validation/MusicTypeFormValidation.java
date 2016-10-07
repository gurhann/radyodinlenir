package com.itaki.radyodinlenir.web.validation;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.itaki.radyodinlenir.web.dto.MusicTypeDTO;

@Component
public class MusicTypeFormValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return MusicTypeDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MusicTypeDTO musicType =(MusicTypeDTO) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if(musicType.getName().length() > 255) {
            errors.rejectValue("name", "MaxLength.255");
        }
	}

}
