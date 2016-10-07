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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itaki.radyodinlenir.exception.RadioStationIsExistException;
import com.itaki.radyodinlenir.service.impl.MusicTypeServiceImpl;
import com.itaki.radyodinlenir.service.impl.RadioStationCityServiceImpl;
import com.itaki.radyodinlenir.service.impl.RadioStationServiceImpl;
import com.itaki.radyodinlenir.util.PageUtils;
import com.itaki.radyodinlenir.web.dto.MusicTypeDTO;
import com.itaki.radyodinlenir.web.dto.RadioStationCityDTO;
import com.itaki.radyodinlenir.web.dto.RadioStationDTO;
import com.itaki.radyodinlenir.web.tools.UploadingService;
import com.itaki.radyodinlenir.web.validation.RadioStationFormValidator;

@Controller
public class RadioStationController {

	@Autowired
	RadioStationServiceImpl radioStationService;

	@Autowired
	MusicTypeServiceImpl musicTypeService;

	@Autowired
	RadioStationFormValidator radioStationFormvalidator;

	@Autowired
	RadioStationCityServiceImpl cityService;

	@Autowired
	UploadingService uploadService;

	@Autowired
	MessageSource msgsrc;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(radioStationFormvalidator);
	}
	
	@RequestMapping(value = "/admin/radios/{pageIndex}", method = RequestMethod.GET)
	public String getMusicTypeList(Model model, @PathVariable(value = "pageIndex") Integer pageIndex) {
		try {
			int radioStationCount = radioStationService.getRadioStationsCount();
			List<RadioStationDTO> radioStationList = null;
			int maxPageIndex = (int) Math.ceil((double) radioStationCount / 10);
			if (pageIndex == null || pageIndex < 1 || pageIndex > maxPageIndex) {
				pageIndex = 1;
			}
			radioStationList = radioStationService.getRadioStationForPager(pageIndex, 10);
			model.addAttribute("maxPageIndex", maxPageIndex);
			model.addAttribute("pageIndex", pageIndex);
			model.addAttribute("radioStationList", radioStationList);
			return "radiostations";
		} catch (Exception e) {
			return "error500";
		}
	}

	@ModelAttribute("musicTypes")
	public List<MusicTypeDTO> getMusicListDTO() {
		return musicTypeService.getAllMusicTypes();
	}

	@ModelAttribute("cities")
	public List<RadioStationCityDTO> getCitiesDTO() {
		return cityService.getAllRadioStationCity();
	}

	@RequestMapping(value = "/admin/radios/add", method = RequestMethod.GET)
	public String getRadioStationAddForm(Model model) {
		try {
			model.addAttribute("radiostation", new RadioStationDTO());
			return "radiostationAddEdit";
		} catch (Exception e) {
			return "error500";
		}
	}

	@RequestMapping(value = "/admin/radios/{deleteid}/delete", method = RequestMethod.GET)
	public String deleteContactRequestWithId(@PathVariable(value = "deleteid") Integer id, Model model, final RedirectAttributes redirectAttributes, Locale locale) {
		try {
			radioStationService.deleteRadioStation(id);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", msgsrc.getMessage("Form.Succesfull", new String[] {}, locale));
			return "redirect:/admin/radios/1";

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", msgsrc.getMessage("Form.Alert", new String[] {}, locale));
			return "redirect:/admin/radios/1";
		}
	}

	@RequestMapping(value = "/admin/radios/add", method = RequestMethod.POST)
	public String postRadioStationAddForm(@ModelAttribute("radiostation") @Validated RadioStationDTO radiostation, BindingResult result, Model model, final RedirectAttributes redirectAttributes,
			Locale locale) {
		if (result.hasErrors()) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", msgsrc.getMessage("Form.Alert", new String[] {}, locale));
			return "radiostationAddEdit";
		}
		try {
			radiostation.setCleanUrl(PageUtils.convertCleanUrl(radiostation.getName()).concat("_dinle"));
			if (!radiostation.getLogoFile().isEmpty()) {
				radiostation.setLogo(uploadService.uploadImage(radiostation.getLogoFile()));
			}
			if (radiostation.getId() == 0) {
				radiostation.setEnabled(true);
				radioStationService.addRadioStation(radiostation);
			} else {
				radioStationService.updateRadioStation(radiostation);
			}
		} catch (RadioStationIsExistException e) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", msgsrc.getMessage("RadioStation.IsExist.Exception", new String[] {}, locale));
			return "radiostationAddEdit";
		} catch (Exception e) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", msgsrc.getMessage("Form.Alert", new String[] {}, locale));

			return "radiostationAddEdit";
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", msgsrc.getMessage("Form.Succesfull", new String[] {}, locale));
		return "redirect:/admin/radios/add";

	}

	@RequestMapping(value = "/admin/radios/{radioStationID}/details", method = RequestMethod.GET)
	public String getRadioStationDetails(@PathVariable(value = "radioStationID") Integer id, Model model) {
		try {
			model.addAttribute("radiostation", radioStationService.getRadioStationWithID(id));
			return "radiostationAddEdit";
		} catch (Exception e) {
			return "error500";
		}
	}
}
