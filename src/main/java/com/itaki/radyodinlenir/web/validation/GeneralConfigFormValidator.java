package com.itaki.radyodinlenir.web.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.itaki.radyodinlenir.web.dto.ApplicationGeneralConfigsDTO;

@Component
public class GeneralConfigFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return ApplicationGeneralConfigsDTO.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		ApplicationGeneralConfigsDTO generalConfigs = (ApplicationGeneralConfigsDTO) arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty.generalConfigsForm.title");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty.generalConfigsForm.description");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "keywords", "NotEmpty.generalConfigsForm.keywords");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "copyright", "NotEmpty.generalConfigsForm.copyright");
		if (generalConfigs.getTitle().length() > 255) {
			errors.rejectValue("title", "MaxLength.generalConfigsForm.title");
		}
		if (generalConfigs.getDescription().length() > 255) {
			errors.rejectValue("description", "MaxLength.generalConfigsForm.description");
		}
		if (generalConfigs.getKeywords().length() > 255) {
			errors.rejectValue("keywords", "MaxLength.generalConfigsForm.keywords");
		}
		if (generalConfigs.getCopyright().length() > 255) {
			errors.rejectValue("copyright", "MaxLength.generalConfigsForm.copyright");
		}
	}

}
