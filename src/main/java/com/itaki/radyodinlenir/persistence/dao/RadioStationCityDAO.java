package com.itaki.radyodinlenir.persistence.dao;

import javax.persistence.NoResultException;

import com.itaki.radyodinlenir.persistence.model.RadioStationCity;

public interface RadioStationCityDAO extends GenericDAO<RadioStationCity> {
	
	public RadioStationCity getRadioStationCityByCleanUrl(String cleanUrl) throws NoResultException;

}
