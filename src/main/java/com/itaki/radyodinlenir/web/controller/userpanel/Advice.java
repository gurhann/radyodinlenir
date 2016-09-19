package com.itaki.radyodinlenir.web.controller.userpanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.itaki.radyodinlenir.service.MusicTypeService;

@ControllerAdvice
public class Advice {

	@Autowired
	private MusicTypeService musicTypeService;

	@ModelAttribute
	public void setMusicTypes(Model model) {
		model.addAttribute("musicTypeList", musicTypeService.getAllMusicTypes());
	}
}
