package com.itaki.radyodinlenir.service;

import java.util.List;
import com.itaki.radyodinlenir.persistence.model.RadioStation;

public interface RadioStationService {
	
	public RadioStation addRadioStation(RadioStation radioStation);
	
	public void updateRadioStation(RadioStation radioStation);
	
	public void  deleteRadioStation(int id);
	
	public RadioStation getRadioStationWithCleanUrl(String cleanUrl);
	
	public List<RadioStation> getRadioStationForPager(int page, int itemSize);
	
	public List<RadioStation> getRadioStationForPagerWithMusicType(int page, int itemSize,int musicTypeId);
	
	public int getRadioStationsCount();
	
	public int getRadioStationsCountWithMusicTypeId(int musicTypeId);	
	
	public List<RadioStation> searchRadioStationWithSearchText(String searchText);
	
}
