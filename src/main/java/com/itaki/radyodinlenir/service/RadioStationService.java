package com.itaki.radyodinlenir.service;

import java.util.List;
import com.itaki.radyodinlenir.persistence.model.RadioStation;
import com.itaki.radyodinlenir.web.dto.RadioStationDTO;

public interface RadioStationService {
	
	public RadioStation addRadioStation(RadioStationDTO radioStation);
	
	public void updateRadioStation(RadioStationDTO radioStation);
	
	public void  deleteRadioStation(int id);
	
	public RadioStationDTO getRadioStationWithCleanUrl(String cleanUrl);
	
	public List<RadioStationDTO> getRadioStationForPager(int page, int itemSize);
	
	public List<RadioStationDTO> getRadioStationForPagerWithMusicType(int page, int itemSize,int musicTypeId);
	
	public int getRadioStationsCount();
	
	public int getRadioStationsCountWithMusicTypeId(int musicTypeId);	
	
	public List<RadioStationDTO> searchRadioStationWithSearchText(String searchText);
	
}
