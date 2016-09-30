package com.itaki.radyodinlenir.persistence.dao;

import java.util.List;

import javax.persistence.NoResultException;

import com.itaki.radyodinlenir.persistence.model.RadioStation;

public interface RadioStationDAO extends GenericDAO<RadioStation> {

	public RadioStation getRadioStationByName(String name) throws NoResultException;

	public RadioStation getRadioStationWithCleanUrl(String cleanUrl) throws NoResultException;

	public RadioStation getRadioStationWithID(Integer id) throws NoResultException;

	public List<RadioStation> getRadioStationForPager(int page, int itemSize);

	public List<RadioStation> getRadioStationForUserPager(int page, int itemSize);

	public int getRadioStationForUserPagerCount();

	public List<RadioStation> getRadioStationForPagerWithMusicType(int page, int itemSize, int musicTypeId);

	public int getRadioStationsCountWithMusicTypeId(int musicTypeId);

	public List<RadioStation> getRadioStationForPagerWithCity(int page, int itemSize, int cityId);

	public int getRadioStationsCountWithCityId(int cityId);

	public List<RadioStation> searchRadioStationWithSearchText(String searchText);

	public List<RadioStation> getNewestRadioStationForPage(int page, int itemSize);

}
