package com.itaki.radyodinlenir.service;

import java.util.List;

import com.itaki.radyodinlenir.exception.MusicTypeIsExistException;
import com.itaki.radyodinlenir.exception.MusicTypeNotFoundException;
import com.itaki.radyodinlenir.web.dto.MusicTypeDTO;

public interface MusicTypeService {

	public void addMusicType(MusicTypeDTO musicType) throws MusicTypeIsExistException;

	public void updateMusicType(MusicTypeDTO musicType) throws MusicTypeNotFoundException;

	public void deleteMusicType(int id) throws MusicTypeNotFoundException;

	public MusicTypeDTO getMusicTypeById(int id) throws MusicTypeNotFoundException;

	public MusicTypeDTO getMusicTypeByCleanUrl(String cleanUrl) throws MusicTypeNotFoundException;

	public List<MusicTypeDTO> getAllMusicTypes();
	
}
