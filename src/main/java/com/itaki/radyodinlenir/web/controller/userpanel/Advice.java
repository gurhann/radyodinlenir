package com.itaki.radyodinlenir.web.controller.userpanel;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.itaki.radyodinlenir.service.ApplicationConfigService;
import com.itaki.radyodinlenir.service.MusicTypeService;
import com.itaki.radyodinlenir.service.impl.RadioStationCityServiceImpl;

@ControllerAdvice
public class Advice {

	@Autowired
	private MusicTypeService musicTypeService;
	
	@Autowired 
	private ApplicationConfigService appConfigService;
	
	@Autowired
	private RadioStationCityServiceImpl cityService;

	@ModelAttribute
	public void setMusicTypes(HttpServletRequest req) {
		if (req.getSession().getAttribute("musicTypeList") == null) {
			req.getSession().setAttribute("musicTypeList", musicTypeService.getAllMusicTypes());
		}
		if (req.getSession().getAttribute("configs") == null) {
			req.getSession().setAttribute("configs", appConfigService.getAllApplicationConfigs());
		}
		if (req.getSession().getAttribute("cities") == null) {
			req.getSession().setAttribute("cities", cityService.getAllRadioStationCity());
		}
	}
}
