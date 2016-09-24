package com.itaki.radyodinlenir.web.controller.userpanel;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.itaki.radyodinlenir.service.ApplicationConfigService;
import com.itaki.radyodinlenir.service.MusicTypeService;
import com.itaki.radyodinlenir.service.impl.RadioStationCityServiceImpl;
import com.itaki.radyodinlenir.web.dto.ApplicationConfigDTO;

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
		if (req.getSession().getAttribute("cities") == null) {
			req.getSession().setAttribute("cities", cityService.getAllRadioStationCity());
		}
		if (req.getSession().getAttribute("configs") == null) {
			List<ApplicationConfigDTO> appConfDTO =appConfigService.getAllApplicationConfigs();
			req.getSession().setAttribute("configs", appConfDTO);
			for (ApplicationConfigDTO applicationConfigDTO : appConfDTO) {
				req.getSession().setAttribute(applicationConfigDTO.getShortCode(), applicationConfigDTO);
			}
		}
	}
}
