package com.itaki.radyodinlenir.persistence.dao.jpa_impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.itaki.radyodinlenir.persistence.dao.ApplicationConfigDAO;
import com.itaki.radyodinlenir.persistence.model.ApplicationConfig;
import com.itaki.radyodinlenir.util.QueryUtil;

@Repository
public class ApplicationConfigDAOImpl extends GenericDAOImpl<ApplicationConfig> implements ApplicationConfigDAO {

	public ApplicationConfigDAOImpl() {
		setClazz(ApplicationConfig.class);
	}

	@Override
	public ApplicationConfig getApplicatonConfigByName(String name) throws NoResultException {
		Query query = em.createNamedQuery(ApplicationConfig.GET_APPLICATION_CONFIG_BY_NAME).setParameter("name", name);
		return (ApplicationConfig) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApplicationConfig> getApplicationConfigListByPage(int pageNumber, int pageSize) {
		Query query = QueryUtil.getIntervalFromQuery(em.createNamedQuery(ApplicationConfig.GET_ALL_APPLICATON_CONFIGS), pageNumber, pageSize);
		return (List<ApplicationConfig>) query.getResultList();
	}
}
