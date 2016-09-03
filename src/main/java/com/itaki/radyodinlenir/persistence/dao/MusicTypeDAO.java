package com.itaki.radyodinlenir.persistence.dao;

import java.util.List;

import com.itaki.radyodinlenir.persistence.model.MusicType;

public interface MusicTypeDAO extends GenericDAO<MusicType>{
	
	public List<MusicType> getAllMusicTypes();
}
