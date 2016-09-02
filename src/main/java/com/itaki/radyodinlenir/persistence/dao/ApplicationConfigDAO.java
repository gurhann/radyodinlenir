package com.itaki.radyodinlenir.persistence.dao;

import java.util.List;

import javax.persistence.NoResultException;

import com.itaki.radyodinlenir.persistence.model.ApplicationConfig;

public interface ApplicationConfigDAO extends GenericDAO<ApplicationConfig> {

	public ApplicationConfig getApplicatonConfigByName(String name) throws NoResultException;
	
	public List<ApplicationConfig> getApplicationConfigListByPage(int pageNumber, int pageSize);
}
