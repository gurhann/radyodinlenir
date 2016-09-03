package com.itaki.radyodinlenir.service.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itaki.radyodinlenir.exception.MusicTypeIsExistException;
import com.itaki.radyodinlenir.exception.MusicTypeNotFoundException;
import com.itaki.radyodinlenir.mapper.MusicTypeMapper;
import com.itaki.radyodinlenir.persistence.dao.MusicTypeDAO;
import com.itaki.radyodinlenir.persistence.model.MusicType;
import com.itaki.radyodinlenir.service.MusicTypeService;
import com.itaki.radyodinlenir.web.dto.MusicTypeDTO;

@Service
public class MusicTypeServiceImpl implements MusicTypeService {

	@Autowired
	private MusicTypeDAO musicTypeDAO;

	@Override
	public void addMusicType(MusicTypeDTO musicTypeDTO) throws MusicTypeIsExistException {
		try {
			musicTypeDAO.getMusicTypeByName(musicTypeDTO.getName());
			throw new MusicTypeIsExistException(musicTypeDTO.getName());
		} catch (NoResultException e) {
		}
		musicTypeDAO.create(MusicTypeMapper.dtoToModel(musicTypeDTO));
	}

	@Override
	public void updateMusicType(MusicTypeDTO musicTypeDTO) throws MusicTypeNotFoundException {
		MusicType musicType = musicTypeDAO.findOne(musicTypeDTO.getId());
		if (musicType == null) {
			throw new MusicTypeNotFoundException(musicTypeDTO.getId());
		}
		musicTypeDAO.update(MusicTypeMapper.dtoToModel(musicTypeDTO));
	}

	@Override
	public void deleteMusicType(int id) throws MusicTypeNotFoundException {
		MusicType musicType = musicTypeDAO.findOne(id);
		if (musicType == null) {
			throw new MusicTypeNotFoundException(id);
		}
		musicTypeDAO.delete(musicType);

	}

	@Override
	public MusicTypeDTO getMusicTypeById(int id) throws MusicTypeNotFoundException {
		MusicType musicType = musicTypeDAO.findOne(id);
		if (musicType == null) {
			throw new MusicTypeNotFoundException(id);
		}
		return MusicTypeMapper.modelToDto(musicType);
	}

	@Override
	public List<MusicTypeDTO> getAllMusicTypes() {
		List<MusicType> musicTypes = musicTypeDAO.getAllMusicTypes();
		return MusicTypeMapper.modelToDtoList(musicTypes);
	}

}
