package com.itaki.radyodinlenir.persistence.dao.jpa_impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.itaki.radyodinlenir.persistence.dao.RadioStationCityDAO;
import com.itaki.radyodinlenir.persistence.model.RadioStationCity;

@Repository
public class RadioStationCityDAOImpl extends GenericDAOImpl<RadioStationCity> implements RadioStationCityDAO {

	public RadioStationCityDAOImpl() {
		setClazz(RadioStationCity.class);
	}

	@Override
	public RadioStationCity getRadioStationCityByCleanUrl(String cleanUrl) throws NoResultException {
		Query query = em.createNamedQuery(RadioStationCity.FIND_RADIO_STATION_CITY_BY_CLEANURL).setParameter("cleanUrl", cleanUrl);
		return (RadioStationCity) query.getSingleResult();
	}
}
