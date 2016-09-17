package com.itaki.radyodinlenir.web.controller.userpanel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itaki.radyodinlenir.service.RadioStationService;
import com.itaki.radyodinlenir.web.dto.RadioStationDTO;

@Controller
@RequestMapping(value = "/")
public class IndexController {

	@Autowired
	private RadioStationService radioStationService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		List<RadioStationDTO> popularRadios = radioStationService.getRadioStationForPager(1, 14);
		List<RadioStationDTO> newestRadios = radioStationService.getNewestRadioStation(1, 14);
		model.addAttribute("popularRadios", popularRadios);
		model.addAttribute("newestRadios", newestRadios);
		return "index";
	}
	
}
