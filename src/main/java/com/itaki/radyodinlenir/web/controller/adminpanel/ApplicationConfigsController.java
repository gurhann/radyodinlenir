package com.itaki.radyodinlenir.web.controller.adminpanel;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itaki.radyodinlenir.service.ApplicationConfigService;
import com.itaki.radyodinlenir.web.dto.ApplicationConfigDTO;
import com.itaki.radyodinlenir.web.dto.ApplicationGeneralConfigsDTO;
import com.itaki.radyodinlenir.web.validation.GeneralConfigFormValidator;

@Controller
public class ApplicationConfigsController {
	private static final Logger logger = Logger.getLogger(ApplicationConfigsController.class);
	@Autowired
	ApplicationConfigService appConfigService;
	@Autowired
	GeneralConfigFormValidator  generalConfigFormValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(generalConfigFormValidator);
	}

	
	@RequestMapping(value="/admin/generalconfig", method=RequestMethod.GET)
	public String getGeneralConfigs(Model model){
		try {
			List<ApplicationConfigDTO> appConfig = appConfigService.getApplicationConfigListBySize(0, 5);
			ApplicationGeneralConfigsDTO generalConfigsForm = new ApplicationGeneralConfigsDTO();
			generalConfigsForm.setTitle(appConfig.get(0).getDescription());
			generalConfigsForm.setDescription(appConfig.get(1).getDescription());
			generalConfigsForm.setKeywords(appConfig.get(2).getDescription());
			generalConfigsForm.setCopyright(appConfig.get(3).getDescription());
			model.addAttribute("generalConfigsForm", generalConfigsForm);
			return "generalconfigs";
		} catch (Exception e) {
			return "error403";
		}		
	
	}
	
	@RequestMapping(value = "/admin/generalconfig", method = RequestMethod.POST)
	public String generalConfigSubmit(@ModelAttribute("generalConfigsForm")  @Validated ApplicationGeneralConfigsDTO generalConfigsForm,BindingResult result, Model model,  final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "generalconfigs";
		} else {

			redirectAttributes.addFlashAttribute("css", "success");		
			redirectAttributes.addFlashAttribute("msg", "Genel Ayarlar Başarıyla Güncellendi!");
			return "redirect:/admin/generalconfig";

		
		}
		
		
		
		
		
		
	}
	
}
