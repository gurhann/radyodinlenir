package com.itaki.radyodinlenir.service.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itaki.radyodinlenir.exception.RadioStationIsExistException;
import com.itaki.radyodinlenir.exception.RadioStationNotFoundException;
import com.itaki.radyodinlenir.mapper.RadioStationMapper;
import com.itaki.radyodinlenir.persistence.dao.RadioStationDAO;
import com.itaki.radyodinlenir.persistence.model.RadioStation;
import com.itaki.radyodinlenir.service.RadioStationService;
import com.itaki.radyodinlenir.web.dto.RadioStationDTO;

@Service
public class RadioStationServiceImpl implements RadioStationService {

	@Autowired
	private RadioStationDAO radioStationDAO;

	@Override
	public void addRadioStation(RadioStationDTO radioStation) throws RadioStationIsExistException {
		try {
			radioStationDAO.getRadioStationByName(radioStation.getName());
			throw new RadioStationIsExistException(radioStation.getName());
		} catch (NoResultException e) {
		}
		radioStationDAO.create(RadioStationMapper.dtoToModel(radioStation));
	}

	@Override
	public void updateRadioStation(RadioStationDTO radioStation) throws RadioStationNotFoundException {
		RadioStation station = radioStationDAO.findOne(radioStation.getId());
		if (station == null) {
			throw new RadioStationNotFoundException(radioStation.getId());
		}
		radioStationDAO.update(RadioStationMapper.dtoToModel(radioStation));
	}

	@Override
	public void deleteRadioStation(int id) throws RadioStationNotFoundException {
		RadioStation station = radioStationDAO.findOne(id);
		if (station == null) {
			throw new RadioStationNotFoundException(id);
		}
		radioStationDAO.delete(station);
	}

	@Override
	public RadioStationDTO getRadioStationWithCleanUrl(String cleanUrl) throws RadioStationNotFoundException {
		try {
			RadioStation radioStationWithCleanUrl = radioStationDAO.getRadioStationWithCleanUrl(cleanUrl);
			return RadioStationMapper.modelToDto(radioStationWithCleanUrl);
		} catch (NoResultException e) {
			throw new RadioStationNotFoundException(cleanUrl);
		}
	}

	@Override
	public List<RadioStationDTO> getRadioStationForPager(int page, int itemSize) {
		List<RadioStation> stationList = radioStationDAO.getRadioStationForPager(page, itemSize);
		return RadioStationMapper.modelToDtoList(stationList);
	}

	@Override
	public List<RadioStationDTO> getRadioStationForPagerWithMusicType(int page, int itemSize, int musicTypeId) {
		List<RadioStation> stationList = radioStationDAO.getRadioStationForPagerWithMusicType(page, itemSize, musicTypeId);
		return RadioStationMapper.modelToDtoList(stationList);
	}

	@Override
	public int getRadioStationsCount() {
		return radioStationDAO.getRowCount();
	}

	@Override
	public int getRadioStationsCountWithMusicTypeId(int musicTypeId) {
		return radioStationDAO.getRadioStationsCountWithMusicTypeId(musicTypeId);
	}

	@Override
	public List<RadioStationDTO> searchRadioStationWithSearchText(String searchText) {
		List<RadioStation> searchRadioStationWithSearchText = radioStationDAO.searchRadioStationWithSearchText(searchText);
		return RadioStationMapper.modelToDtoList(searchRadioStationWithSearchText);
	}

}
