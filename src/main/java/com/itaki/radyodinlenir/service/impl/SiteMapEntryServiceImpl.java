package com.itaki.radyodinlenir.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itaki.radyodinlenir.service.MusicTypeService;
import com.itaki.radyodinlenir.service.RadioStationCityService;
import com.itaki.radyodinlenir.service.RadioStationService;
import com.itaki.radyodinlenir.service.SiteMapEntryService;
import com.itaki.radyodinlenir.web.dto.MusicTypeDTO;
import com.itaki.radyodinlenir.web.dto.RadioStationCityDTO;
import com.itaki.radyodinlenir.web.dto.RadioStationDTO;

import cz.jiripinkas.jsitemapgenerator.WebPageBuilder;
import cz.jiripinkas.jsitemapgenerator.generator.SitemapGenerator;

@Service
public class SiteMapEntryServiceImpl implements SiteMapEntryService {
	private static final String BASE_URL = "http://radyodinlenir.com";
	private static final String CITY_PATH = "radiosofcity/";
	private static final String RADIO_PATH = "station/";
	private static final String MUSIC_TYPE_PATH = "stations/";

	@Autowired
	RadioStationCityService cityService;

	@Autowired
	RadioStationService radioStationService;

	@Autowired
	MusicTypeService musicTypeService;

	@Override
	public String createSiteMap() {
		SitemapGenerator sitemapGenerator = new SitemapGenerator(BASE_URL);
		try {
			for (RadioStationDTO dto : radioStationService.findAll()) {
				sitemapGenerator.addPage(new WebPageBuilder().name(RADIO_PATH + dto.getCleanUrl()).lastMod(dto.getAddDate()).build());				
			}
			for (RadioStationCityDTO dto : cityService.getAllRadioStationCity()) {
				sitemapGenerator.addPage(new WebPageBuilder().name(CITY_PATH + dto.getCleanUrl()).build());
			}
			for (MusicTypeDTO dto : musicTypeService.getAllMusicTypes()) {
				sitemapGenerator.addPage(new WebPageBuilder().name(MUSIC_TYPE_PATH + dto.getCleanUrl()).build());
			}			
			sitemapGenerator.addPage(new WebPageBuilder().name("").build());

			return sitemapGenerator.constructSitemapString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sitemapGenerator.constructSitemapString();		
	}

}
