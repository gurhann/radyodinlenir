package com.itaki.radyodinlenir.persistence.dao.jpa_impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.itaki.radyodinlenir.persistence.dao.MusicTypeDAO;
import com.itaki.radyodinlenir.persistence.model.MusicType;

@Repository
public class MusicTypeDAOImpl extends GenericDAOImpl<MusicType> implements MusicTypeDAO {

	public MusicTypeDAOImpl() {
		setClazz(MusicType.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MusicType> getAllMusicTypes() {
		Query query = em.createNamedQuery(MusicType.GET_ALL_MUSIC_TYPES);
		return (List<MusicType>) query.getResultList();
	}
}
