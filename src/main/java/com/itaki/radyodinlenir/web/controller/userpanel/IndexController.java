package com.itaki.radyodinlenir.web.controller.userpanel;

import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itaki.radyodinlenir.exception.RadioStationCityNotFoundException;
import com.itaki.radyodinlenir.exception.RadioStationNotFoundException;
import com.itaki.radyodinlenir.service.MusicTypeService;
import com.itaki.radyodinlenir.service.RadioStationCityService;
import com.itaki.radyodinlenir.service.RadioStationService;
import com.itaki.radyodinlenir.service.SearchTermsService;
import com.itaki.radyodinlenir.util.PageUtils;
import com.itaki.radyodinlenir.web.dto.ApplicationConfigDTO;
import com.itaki.radyodinlenir.web.dto.MusicTypeDTO;
import com.itaki.radyodinlenir.web.dto.RadioStationCityDTO;
import com.itaki.radyodinlenir.web.dto.RadioStationDTO;
import com.itaki.radyodinlenir.web.dto.SearchTermsDTO;

@Controller
@RequestMapping(value = "/")
public class IndexController {

	@Autowired
	private RadioStationService radioStationService;

	@Autowired
	private MusicTypeService musicTypeService;

	@Autowired
	private SearchTermsService searchTermsService;

	@Autowired
	private RadioStationCityService radioSTationCityService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest req) throws RadioStationNotFoundException {
		List<RadioStationDTO> popularRadios = radioStationService.getRadioStationForUserPager(1, 18);
		List<RadioStationDTO> newestRadios = radioStationService.getNewestRadioStation(1, 18);
		int radioId = Integer
				.parseInt(((ApplicationConfigDTO) req.getSession().getAttribute("mainpageradio")).getDescription());
		model.addAttribute("item", radioStationService.getRadioStationWithID(radioId));
		model.addAttribute("popularRadios", popularRadios);
		model.addAttribute("newestRadios", newestRadios);
		return "index";
	}

	@RequestMapping(value = "/stations/{musicTypeName}/{pageIndex}", method = RequestMethod.GET)
	public String getRadioListByMusicType(@PathVariable("musicTypeName") String musicTypeName,
			@PathVariable("pageIndex") Integer pageIndex, Model model) {
		try {
			MusicTypeDTO musicType = musicTypeService.getMusicTypeByCleanUrl(musicTypeName);
			int totalCount = radioStationService.getRadioStationsCountWithMusicTypeId(musicType.getId());
			int maxPageIndex = PageUtils.getPageCount(totalCount, 30);
			if (pageIndex == null || pageIndex < 1 || pageIndex > maxPageIndex) {
				pageIndex = 1;
			}
			List<RadioStationDTO> radioStationList = radioStationService.getRadioStationForPagerWithMusicType(pageIndex,
					30, musicType.getId());
			model.addAttribute("radioList", radioStationList);
			model.addAttribute("maxPageIndex", maxPageIndex);
			model.addAttribute("item", musicType);
			model.addAttribute("pageIndex", pageIndex);
			model.addAttribute("iTitle", musicType.getName() + " Radyolar |");
			model.addAttribute("pagerBaseUrl", "/stations/" + musicTypeName);
		} catch (NoResultException e) {
			return "error404";
		} catch (Exception e) {
			return "error500";
		}
		return "radioList";
	}

	@RequestMapping(value = "/radiosofcity/{cityName}/{pageIndex}", method = RequestMethod.GET)
	public String getRadioListByCity(@PathVariable("cityName") String cityName,
			@PathVariable("pageIndex") Integer pageIndex, Model model) {
		try {
			RadioStationCityDTO radioStationCity = radioSTationCityService.getRadioStationCityByCleanUrl(cityName);
			int totalCount = radioStationService.getRadioStationsCountWithCityId(radioStationCity.getId());
			int maxPageIndex = PageUtils.getPageCount(totalCount, 30);
			if (pageIndex == null || pageIndex < 1 || pageIndex > maxPageIndex) {
				pageIndex = 1;
			}
			List<RadioStationDTO> radioStationList = radioStationService.getRadioStationForPagerWithCity(pageIndex, 30,
					radioStationCity.getId());
			model.addAttribute("radioList", radioStationList);
			model.addAttribute("maxPageIndex", maxPageIndex);
			model.addAttribute("item", radioStationCity);
			model.addAttribute("pageIndex", pageIndex);
			model.addAttribute("pagerBaseUrl", "/radiosofcity/" + cityName);
			model.addAttribute("iTitle", radioStationCity.getName() + " Radyoları |");
		} catch (RadioStationCityNotFoundException e) {
			return "error404";
		} catch (Exception e) {
			return "error500";
		}
		return "radioList";
	}

	@RequestMapping(value = "/popularStations/{pageIndex}")
	public String getPopularRadioStations(@PathVariable("pageIndex") Integer pageIndex, Model model) {
		int totalCount = radioStationService.getRadioStationForUserPagerCount();
		int maxPageIndex = PageUtils.getPageCount(totalCount, 30);
		if (pageIndex == null || pageIndex < 1 || pageIndex > maxPageIndex) {
			pageIndex = 1;
		}
		List<RadioStationDTO> radioList = radioStationService.getRadioStationForUserPager(pageIndex, 30);
		model.addAttribute("radioList", radioList);
		model.addAttribute("maxPageIndex", maxPageIndex);
		model.addAttribute("pageIndex", pageIndex);
		model.addAttribute("pagerBaseUrl", "/popularStations");
		model.addAttribute("iTitle", "Popüler Radyolar ");
		return "radioList";
	}

	@RequestMapping(value = "/newestStations/{pageIndex}")
	public String getNewestRadioStations(@PathVariable("pageIndex") Integer pageIndex, Model model) {
		int totalCount = radioStationService.getRadioStationsCount();
		int maxPageIndex = PageUtils.getPageCount(totalCount, 30);
		if (pageIndex == null || pageIndex < 1 || pageIndex > maxPageIndex) {
			pageIndex = 1;
		}
		List<RadioStationDTO> radioList = radioStationService.getNewestRadioStation(pageIndex, 30);
		model.addAttribute("radioList", radioList);
		model.addAttribute("maxPageIndex", maxPageIndex);
		model.addAttribute("pageIndex", pageIndex);
		model.addAttribute("pagerBaseUrl", "/newestStations");
		model.addAttribute("iTitle", "Son Eklenen Radyolar ");
		return "radioList";
	}

	@RequestMapping(value = "/station/{cleanIUrl}")
	public String getRadioStationWithCleanUrl(@PathVariable("cleanIUrl") String cleanUrl, Model model) {
		try {
			RadioStationDTO radio = radioStationService.getRadioStationWithCleanUrl(cleanUrl);
			model.addAttribute("item", radio);
			radio.setHitCount(radio.getHitCount() + 1);
			model.addAttribute("iTitle", radio.getName() + " Dinle |");
			model.addAttribute("similarRadios",
					radioStationService.getRadioStationForPagerWithMusicType(1, 8, radio.getMusicType().getId()));
			radioStationService.updateRadioStation(radio);
		} catch (NoResultException e) {
			return "error404";
		} catch (Exception e) {
			System.out.println(e);
			return "error500";
		}
		return "radioView";
	}

	@RequestMapping(value = "/stations/{musicTypeName}")
	public String getRadioListByMusicType(@PathVariable("musicTypeName") String musicTypeName) {
		return "forward:/stations/" + musicTypeName + "/1";
	}

	@RequestMapping(value = "/radiosofcity/{cityName}")
	public String getRadioListByCity(@PathVariable("cityName") String cityName) {
		return "forward:/radiosofcity/" + cityName + "/1";
	}

	@RequestMapping(value = "/popularStations")
	public String getPopularRadioStations() {
		return "forward:/popularStations/1";
	}

	@RequestMapping(value = "/newestStations")
	public String getNewestRadioStations() {
		return "forward:/newestStations/1";
	}

	@RequestMapping(value = "/search")
	public String searchStation(@RequestParam(value = "searchText") String searchText, Model model) {
		List<RadioStationDTO> radioList = radioStationService.searchRadioStationWithSearchText(searchText);
		searchTermsService.addSearchTerm(new SearchTermsDTO(searchText));

		model.addAttribute("radioList", radioList);
		model.addAttribute("searchedText", searchText);
		return "radioList";
	}

}
