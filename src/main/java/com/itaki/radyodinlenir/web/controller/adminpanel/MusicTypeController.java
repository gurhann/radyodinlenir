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

import com.itaki.radyodinlenir.exception.MusicTypeIsExistException;
import com.itaki.radyodinlenir.service.impl.MusicTypeServiceImpl;
import com.itaki.radyodinlenir.util.PageUtils;
import com.itaki.radyodinlenir.web.dto.MusicTypeDTO;
import com.itaki.radyodinlenir.web.validation.MusicTypeFormValidation;

@Controller
public class MusicTypeController {
	@Autowired
	MusicTypeServiceImpl musicTypeService;

	@Autowired
	MessageSource msgsrc;

	@Autowired
	MusicTypeFormValidation formValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(formValidator);
	}

	@RequestMapping(value = "admin/musictypelist", method = RequestMethod.GET)
	public String getMusicTypeList(Model model) {
		try {
			List<MusicTypeDTO> musicTypes = musicTypeService.getAllMusicTypes();
			model.addAttribute("musicTypes", musicTypes);
			model.addAttribute("musicType", new MusicTypeDTO());
			return "musictypelist";
		} catch (Exception e) {
			return "error403";
		}
	}

	@RequestMapping(value = "/admin/musictypelist", method = RequestMethod.POST)
	public String musicTypeFormSubmit(@ModelAttribute("musicType") @Validated MusicTypeDTO musicType, BindingResult result, Model model, final RedirectAttributes redirectAttributes, Locale locale) {
		if (result.hasErrors()) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", msgsrc.getMessage("Form.Alert", new String[] {}, locale));
			return "musictypelist";
		}
		try {
			musicType.setCleanUrl(PageUtils.convertCleanUrl(musicType.getName()));
			musicTypeService.addMusicType(musicType);
		} catch (MusicTypeIsExistException e) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", msgsrc.getMessage("MusicType.IsExist.Exception", new String[] {}, locale));
			return "musictypelist";
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", msgsrc.getMessage("Form.Succesfull", new String[] {}, locale));
		return "redirect:/admin/musictypelist";
	}

	@RequestMapping(value = "admin/musictypelist/{editType}/edit", method = RequestMethod.GET)
	public String getEditMusicTypeForm(@PathVariable(value = "editType")Integer id,Model model) {
		try {			
			model.addAttribute("musicType", musicTypeService.getMusicTypeById(id));
			return "musictypedit";
		} catch (Exception e) {
			return "error403";
		}
	}
	@RequestMapping(value = "admin/musictypelist/{editType}/edit", method = RequestMethod.POST)
	public String postEditMusicTypeForm(@ModelAttribute("musicType") @Validated MusicTypeDTO musicType,BindingResult result,@PathVariable(value = "editType")Integer id,Model model,Locale locale,final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", msgsrc.getMessage("Form.Alert", new String[] {}, locale));
			return "musictypedit";
		}
		try {			
			musicType.setCleanUrl(musicType.getName());
			musicTypeService.updateMusicType(musicType);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", msgsrc.getMessage("Form.Succesfull", new String[] {}, locale));
			return "redirect:/admin/musictypelist/" + id+"/edit";
		} catch (Exception e) {
			return "error403";
		}
	}
	
	
	@RequestMapping(value = "/admin/musictypelist/{deleteCat}/delete")
	public String deleteCategori(@PathVariable(value = "deleteCat") Integer id, Model model ,final RedirectAttributes redirectAttributes,Locale locale) {
		try {
			
			musicTypeService.deleteMusicType(id);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", msgsrc.getMessage("Form.Succesfull", new String[] {}, locale));
			return "redirect:/admin/musictypelist";
			
		} catch (Exception e) {
			System.out.println(e);
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", msgsrc.getMessage("Form.Alert", new String[] {}, locale));
			return "redirect:/admin/musictypelist";
		}


	}


}
