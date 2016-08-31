package com.itaki.radyodinlenir.persistence.dao.jpa_impl;

import org.springframework.stereotype.Repository;

import com.itaki.radyodinlenir.persistence.dao.MusicTypeDAO;
import com.itaki.radyodinlenir.persistence.model.MusicType;

@Repository
public class MusicTypeDAOImpl extends GenericDAOImpl<MusicType> implements MusicTypeDAO {

	public MusicTypeDAOImpl() {
		setClazz(MusicType.class);
	}
}
