package com.itaki.radyodinlenir.persistence.dao.jpa_impl;

import org.springframework.stereotype.Repository;

import com.itaki.radyodinlenir.persistence.dao.RadioStationDAO;
import com.itaki.radyodinlenir.persistence.model.RadioStation;

@Repository
public class RadioStationDAOImpl extends GenericDAOImpl<RadioStation> implements RadioStationDAO {

	public RadioStationDAOImpl() {
		setClazz(RadioStation.class);
	}
}
