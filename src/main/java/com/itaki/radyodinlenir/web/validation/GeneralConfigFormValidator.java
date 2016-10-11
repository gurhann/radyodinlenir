package com.itaki.radyodinlenir.web.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.itaki.radyodinlenir.web.dto.ApplicationConfigDTO;
import com.itaki.radyodinlenir.web.dto.GeneralConfigsFormDTO;

@Component
public class GeneralConfigFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return GeneralConfigsFormDTO.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		GeneralConfigsFormDTO generalConfigs = (GeneralConfigsFormDTO) arg0;
		   for (int i = 0; i < generalConfigs.getConfigs().size(); i++) {
	            ApplicationConfigDTO conf = generalConfigs.getConfigs().get(i);
	            if(conf.getDescription().length() > 500) {
	                errors.rejectValue("configs[" + i + "].description", "MaxLength.5000");
	            }
	            if(conf.getDescription().length() == 0 || conf.getDescription() == null) {
	                errors.rejectValue("configs[" + i + "].description", "NotEmpty");
	            }
	        }
		

	}

}
