package com.itaki.radyodinlenir.persistence.dao;

import java.util.List;

import javax.persistence.NoResultException;

import com.itaki.radyodinlenir.persistence.model.MusicType;

public interface MusicTypeDAO extends GenericDAO<MusicType> {

	public List<MusicType> getAllMusicTypes();

	public MusicType getMusicTypeByName(String name) throws NoResultException;
}
