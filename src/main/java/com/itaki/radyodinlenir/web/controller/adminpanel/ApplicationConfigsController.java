package com.itaki.radyodinlenir.web.controller.adminpanel;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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

import com.itaki.radyodinlenir.exception.ApplicationConfigNotFoundException;
import com.itaki.radyodinlenir.service.ApplicationConfigService;
import com.itaki.radyodinlenir.web.dto.ApplicationConfigDTO;
import com.itaki.radyodinlenir.web.dto.GeneralConfigsFormDTO;
import com.itaki.radyodinlenir.web.validation.GeneralConfigFormValidator;

@Controller
public class ApplicationConfigsController {
	@Autowired
	ApplicationConfigService appConfigService;
	@Autowired
	GeneralConfigFormValidator generalConfigFormValidator;

	@Autowired
	MessageSource msgsrc;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(generalConfigFormValidator);
	}

	@RequestMapping(value = "/admin/generalconfigs", method = RequestMethod.GET)
	public String getGeneralConfigs(Model model, Locale locale) {
		try {
			return getData(model, 0, 5, "generalconfigs");
		} catch (Exception e) {
			return "error500";
		}

	}

	@RequestMapping(value = "/admin/generalconfigs", method = RequestMethod.POST)
	public String generalConfigSubmit(@ModelAttribute("generalConfigsForm") @Validated GeneralConfigsFormDTO generalConfigsForm, BindingResult result, Model model,
			final RedirectAttributes redirectAttributes, Locale locale) {
		return setData(generalConfigsForm, result, model, redirectAttributes, locale, "generalconfigs");

	}

	@RequestMapping(value = "/admin/adwordsconfigs", method = RequestMethod.POST)
	public String adwordsConfigSubmit(@ModelAttribute("generalConfigsForm") @Validated GeneralConfigsFormDTO generalConfigsForm, BindingResult result, Model model,
			final RedirectAttributes redirectAttributes, Locale locale) {
		return setData(generalConfigsForm, result, model, redirectAttributes, locale, "adwordsconfigs");

	}

	@RequestMapping(value = "/admin/seoconfigs", method = RequestMethod.GET)
	public String getSeoConfigs(Model model, Locale locale) {
		try {
			return getData(model, 5, 6, "seoconfigs");
		} catch (Exception e) {
			return "error500";
		}

	}

	@RequestMapping(value = "/admin/socialconfigs", method = RequestMethod.GET)
	public String getSocialConfigs(Model model, Locale locale) {
		try {
			return getData(model, 11, 10, "socialconfigs");
		} catch (Exception e) {
			return "error500";
		}

	}

	@RequestMapping(value = "/admin/aboutconfigs", method = RequestMethod.GET)
	public String getAboutConfigs(Model model, Locale locale) {
		try {
			return getData(model, 21, 1, "aboutconfigs");
		} catch (Exception e) {
			return "error500";
		}
	}
	
	@RequestMapping(value = "/admin/adwordsconfigs", method = RequestMethod.GET)
	public String getAdwordsConfigs(Model model, Locale locale) {
		try {
			return getData(model, 22, 6, "adwordsconfigs");
		} catch (Exception e) {
			return "error500";
		}
	}
	
	
	@RequestMapping(value = "/admin/aboutconfigs", method = RequestMethod.POST)
	public String aboutConfigSubmit(@ModelAttribute("generalConfigsForm") @Validated GeneralConfigsFormDTO generalConfigsForm, BindingResult result, Model model,
			final RedirectAttributes redirectAttributes, Locale locale) {
		return setData(generalConfigsForm, result, model, redirectAttributes, locale, "aboutconfigs");

	}

	public String getData(Model model, int firstIndex, int itemSize, String view) {
		List<ApplicationConfigDTO> appConfig = appConfigService.getApplicationConfigListBySize(firstIndex, itemSize);
		GeneralConfigsFormDTO generalConfigsForm = new GeneralConfigsFormDTO();
		generalConfigsForm.setConfigs(appConfig);
		model.addAttribute("generalConfigsForm", generalConfigsForm);
		return view;
	}

	public String setData(GeneralConfigsFormDTO generalConfigsForm, BindingResult result, Model model, final RedirectAttributes redirectAttributes, Locale locale, String view) {

		if (result.hasErrors()) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", msgsrc.getMessage("Form.Alert", new String[] {}, locale));
			return view;
		}
		try {
			appConfigService.updateMultiApplicationConfig(generalConfigsForm.getConfigs());
		} catch (ApplicationConfigNotFoundException e) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", msgsrc.getMessage("application.config.notfound", new String[] {}, locale));
			return view;
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", msgsrc.getMessage("Form.Succesfull", new String[] {}, locale));
		return "redirect:/admin/" + view;

	}

}
