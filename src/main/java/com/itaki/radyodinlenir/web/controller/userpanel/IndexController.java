package com.itaki.radyodinlenir.web.controller.userpanel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itaki.radyodinlenir.exception.MusicTypeNotFoundException;
import com.itaki.radyodinlenir.exception.RadioStationNotFoundException;
import com.itaki.radyodinlenir.service.MusicTypeService;
import com.itaki.radyodinlenir.service.RadioStationService;
import com.itaki.radyodinlenir.util.PageUtils;
import com.itaki.radyodinlenir.web.dto.MusicTypeDTO;
import com.itaki.radyodinlenir.web.dto.RadioStationDTO;

@Controller
@RequestMapping(value = "/")
public class IndexController {

	@Autowired
	private RadioStationService radioStationService;

	@Autowired
	private MusicTypeService musicTypeService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		List<RadioStationDTO> popularRadios = radioStationService.getRadioStationForPager(1, 14);
		List<RadioStationDTO> newestRadios = radioStationService.getNewestRadioStation(1, 14);
		model.addAttribute("popularRadios", popularRadios);
		model.addAttribute("newestRadios", newestRadios);
		return "index";
	}

	@RequestMapping(value = "/stations/{musicTypeName}/{pageIndex}", method = RequestMethod.GET)
	public String getRadioListByMusicType(@PathVariable("musicTypeName") String musicTypeName, @PathVariable("pageIndex") Integer pageIndex, Model model) {
		try {
			MusicTypeDTO musicType = musicTypeService.getMusicTypeByCleanUrl(musicTypeName);
			int totalCount = radioStationService.getRadioStationsCountWithMusicTypeId(musicType.getId());
			int maxPageIndex = PageUtils.getPageCount(totalCount, 35);
			if (pageIndex == null || pageIndex < 1 || pageIndex > maxPageIndex) {
				pageIndex = 1;
			}
			List<RadioStationDTO> radioStationList = radioStationService.getRadioStationForPagerWithMusicType(pageIndex, 35, musicType.getId());
			model.addAttribute("radioList", radioStationList);
			model.addAttribute("maxPageIndex", maxPageIndex);
			model.addAttribute("pageIndex", pageIndex);
			model.addAttribute("musicTypeName", musicTypeName);
			model.addAttribute("pagerBaseUrl", "/stations/" + musicTypeName);
		} catch (MusicTypeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "radioList";
	}

	@RequestMapping(value = "/popularStations/{pageIndex}")
	public String getPopularRadioStations(@PathVariable("pageIndex") Integer pageIndex, Model model) {
		int totalCount = radioStationService.getRadioStationsCount();
		int maxPageIndex = PageUtils.getPageCount(totalCount, 35);
		if (pageIndex == null || pageIndex < 1 || pageIndex > maxPageIndex) {
			pageIndex = 1;
		}
		List<RadioStationDTO> radioList = radioStationService.getRadioStationForPager(pageIndex, 35);
		model.addAttribute("radioList", radioList);
		model.addAttribute("maxPageIndex", maxPageIndex);
		model.addAttribute("pageIndex", pageIndex);
		model.addAttribute("pagerBaseUrl", "/popularStations");

		return "radioList";
	}

	@RequestMapping(value = "/newestStations/{pageIndex}")
	public String getNewestRadioStations(@PathVariable("pageIndex") Integer pageIndex, Model model) {
		int totalCount = radioStationService.getRadioStationsCount();
		int maxPageIndex = PageUtils.getPageCount(totalCount, 35);
		if (pageIndex == null || pageIndex < 1 || pageIndex > maxPageIndex) {
			pageIndex = 1;
		}
		List<RadioStationDTO> radioList = radioStationService.getNewestRadioStation(pageIndex, 35);
		model.addAttribute("radioList", radioList);
		model.addAttribute("maxPageIndex", maxPageIndex);
		model.addAttribute("pageIndex", pageIndex);
		model.addAttribute("pagerBaseUrl", "/newestStations");
		return "radioList";
	}
	
	@RequestMapping(value = "/station/{cleanIUrl}")
	public String getRadioStationWithCleanUrl(@PathVariable("cleanIUrl") String cleanUrl, Model model) {
		try {
			RadioStationDTO radio = radioStationService.getRadioStationWithCleanUrl(cleanUrl);
			model.addAttribute("radio", radio);
			radio.setHitCount(radio.getHitCount()+1);
			radioStationService.updateRadioStation(radio);
		} catch (RadioStationNotFoundException e) {
			
			return "error404";
		}

		return "radioView";
	}

	@RequestMapping(value = "/stations/{musicTypeName}")
	public String getRadioListByMusicType(@PathVariable("musicTypeName") String musicTypeName) {
		return "forward:/stations/" + musicTypeName + "/1";
	}

	@RequestMapping(value = "/popularStations")
	public String getPopularRadioStations() {
		return "forward:/popularStations/1";
	}

	@RequestMapping(value = "/newestStations")
	public String getNewestRadioStations() {
		return "forward:/newestStations/1";
	}

}
