package com.itaki.radyodinlenir.service;

import java.util.List;

import com.itaki.radyodinlenir.exception.RadioStationCityNotFoundException;
import com.itaki.radyodinlenir.web.dto.RadioStationCityDTO;

public interface RadioStationCityService {


	public RadioStationCityDTO getRadioStationCityByCleanUrl(String cleanUrl) throws RadioStationCityNotFoundException;
	
	public List<RadioStationCityDTO> getAllRadioStationCity();
}
