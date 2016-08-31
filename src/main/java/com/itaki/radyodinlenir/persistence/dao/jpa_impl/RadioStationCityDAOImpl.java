package com.itaki.radyodinlenir.persistence.dao.jpa_impl;

import org.springframework.stereotype.Repository;

import com.itaki.radyodinlenir.persistence.dao.RadioStationCityDAO;
import com.itaki.radyodinlenir.persistence.model.RadioStationCity;

@Repository
public class RadioStationCityDAOImpl extends GenericDAOImpl<RadioStationCity> implements RadioStationCityDAO {
	
	public RadioStationCityDAOImpl() {
		setClazz(RadioStationCity.class);
	}
}
