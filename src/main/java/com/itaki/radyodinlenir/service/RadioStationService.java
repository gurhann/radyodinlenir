package com.itaki.radyodinlenir.service;

import java.util.List;

import com.itaki.radyodinlenir.exception.RadioStationIsExistException;
import com.itaki.radyodinlenir.exception.RadioStationNotFoundException;
import com.itaki.radyodinlenir.web.dto.RadioStationDTO;

public interface RadioStationService {

	public void addRadioStation(RadioStationDTO radioStation) throws RadioStationIsExistException;

	public void updateRadioStation(RadioStationDTO radioStation) throws RadioStationNotFoundException;

	public void deleteRadioStation(int id) throws RadioStationNotFoundException;

	public RadioStationDTO getRadioStationWithCleanUrl(String cleanUrl) throws RadioStationNotFoundException;

	public RadioStationDTO getRadioStationWithID(Integer id) throws RadioStationNotFoundException;

	public List<RadioStationDTO> getRadioStationForPager(int page, int itemSize);

	public List<RadioStationDTO> getRadioStationForUserPager(int page, int itemSize);

	public int getRadioStationForUserPagerCount();

	public List<RadioStationDTO> getRadioStationForPagerWithMusicType(int page, int itemSize, int musicTypeId);

	public int getRadioStationsCount();

	public int getRadioStationsCountWithMusicTypeId(int musicTypeId);

	public List<RadioStationDTO> searchRadioStationWithSearchText(String searchText);

	public List<RadioStationDTO> getNewestRadioStation(int page, int itemSize);

	public List<RadioStationDTO> getRadioStationForPagerWithCity(int page, int itemSize, int cityId);

	public int getRadioStationsCountWithCityId(int cityId);

}
