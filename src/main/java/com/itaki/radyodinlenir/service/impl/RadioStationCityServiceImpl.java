package com.itaki.radyodinlenir.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itaki.radyodinlenir.exception.RadioStationCityNotFoundException;
import com.itaki.radyodinlenir.mapper.RadioStationCityMapper;
import com.itaki.radyodinlenir.persistence.dao.RadioStationCityDAO;
import com.itaki.radyodinlenir.persistence.model.RadioStationCity;
import com.itaki.radyodinlenir.service.RadioStationCityService;
import com.itaki.radyodinlenir.web.dto.RadioStationCityDTO;

@Service
public class RadioStationCityServiceImpl implements RadioStationCityService {

	@Autowired
	private RadioStationCityDAO radioStationCityDAO;

	@Override
	public List<RadioStationCityDTO> getAllRadioStationCity() {
		List<RadioStationCity> allRadioStationCities = radioStationCityDAO.findAll();
		return RadioStationCityMapper.modelToDtoList(allRadioStationCities);
	}

	@Override
	public RadioStationCityDTO getRadioStationCityByCleanUrl(String cleanUrl) throws RadioStationCityNotFoundException {
		RadioStationCity radiotStationCity = radioStationCityDAO.getRadioStationCityByCleanUrl(cleanUrl);
		if (radiotStationCity == null) {
			throw new RadioStationCityNotFoundException(cleanUrl);
		}
		return RadioStationCityMapper.modelToDto(radiotStationCity);
	}

}
