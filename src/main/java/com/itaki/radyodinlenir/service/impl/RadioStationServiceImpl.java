package com.itaki.radyodinlenir.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itaki.radyodinlenir.persistence.dao.RadioStationDAO;
import com.itaki.radyodinlenir.persistence.model.RadioStation;
import com.itaki.radyodinlenir.service.RadioStationService;
import com.itaki.radyodinlenir.web.dto.RadioStationDTO;

@Service
public class RadioStationServiceImpl implements RadioStationService {

	@Autowired
	private RadioStationDAO radioStationDAO;

	@Override
	public RadioStation addRadioStation(RadioStationDTO radioStation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRadioStation(RadioStationDTO radioStation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRadioStation(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public RadioStationDTO getRadioStationWithCleanUrl(String cleanUrl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RadioStationDTO> getRadioStationForPager(int page, int itemSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RadioStationDTO> getRadioStationForPagerWithMusicType(int page, int itemSize, int musicTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRadioStationsCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRadioStationsCountWithMusicTypeId(int musicTypeId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RadioStationDTO> searchRadioStationWithSearchText(String searchText) {
		// TODO Auto-generated method stub
		return null;
	}

}
