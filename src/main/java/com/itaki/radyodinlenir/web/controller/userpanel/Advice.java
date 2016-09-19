package com.itaki.radyodinlenir.web.controller.userpanel;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.itaki.radyodinlenir.service.MusicTypeService;

@ControllerAdvice
public class Advice {

	@Autowired
	private MusicTypeService musicTypeService;

	@ModelAttribute
	public void setMusicTypes(HttpServletRequest req) {
		if (req.getSession().getAttribute("musicTypeList") == null) {
			req.getSession().setAttribute("musicTypeList", musicTypeService.getAllMusicTypes());
		}
	}
}
