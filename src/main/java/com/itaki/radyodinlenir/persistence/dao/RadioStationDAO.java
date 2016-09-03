package com.itaki.radyodinlenir.persistence.dao;

import java.util.List;

import javax.persistence.NoResultException;

import com.itaki.radyodinlenir.persistence.model.RadioStation;

public interface RadioStationDAO extends GenericDAO<RadioStation> {

	public RadioStation getRadioStationByName(String name) throws NoResultException;

	public RadioStation getRadioStationWithCleanUrl(String cleanUrl) throws NoResultException;
	
	public List<RadioStation> getRadioStationForPager(int page, int itemSize) ;

	public List<RadioStation> getRadioStationForPagerWithMusicType(int page, int itemSize, int musicTypeId);
	
	public int getRadioStationsCountWithMusicTypeId(int musicTypeId) ;
	
	public List<RadioStation> searchRadioStationWithSearchText(String searchText);

}
