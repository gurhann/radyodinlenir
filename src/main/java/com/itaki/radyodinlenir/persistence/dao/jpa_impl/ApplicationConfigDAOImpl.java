package com.itaki.radyodinlenir.persistence.dao.jpa_impl;

import org.springframework.stereotype.Repository;

import com.itaki.radyodinlenir.persistence.dao.ApplicationConfigDAO;
import com.itaki.radyodinlenir.persistence.model.ApplicationConfig;

@Repository
public class ApplicationConfigDAOImpl extends GenericDAOImpl<ApplicationConfig> implements ApplicationConfigDAO {

	public ApplicationConfigDAOImpl() {
		setClazz(ApplicationConfig.class);
	}
}
