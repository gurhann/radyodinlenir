package com.itaki.radyodinlenir.service.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itaki.radyodinlenir.exception.ApplicationConfigIsExistException;
import com.itaki.radyodinlenir.exception.ApplicationConfigNotFoundException;
import com.itaki.radyodinlenir.mapper.ApplicationConfigMapper;
import com.itaki.radyodinlenir.persistence.dao.ApplicationConfigDAO;
import com.itaki.radyodinlenir.persistence.model.ApplicationConfig;
import com.itaki.radyodinlenir.service.ApplicationConfigService;
import com.itaki.radyodinlenir.web.dto.ApplicationConfigDTO;

@Service
public class ApplicationConfigServiceImpl implements ApplicationConfigService {

	@Autowired
	private ApplicationConfigDAO configDAO;

	@Override
	public ApplicationConfigDTO addApplicationConfig(ApplicationConfigDTO configDTO) throws ApplicationConfigIsExistException {

		try {
			configDAO.getApplicatonConfigByName(configDTO.getName());
			throw new ApplicationConfigIsExistException(configDTO.getName());
		} catch (NoResultException e) {
		}

		configDAO.create(ApplicationConfigMapper.dtoToModel(configDTO));
		ApplicationConfig addedConfig = configDAO.getApplicatonConfigByName(configDTO.getName());
		configDTO.setId(addedConfig.getId());
		return configDTO;

	}

	@Override
	public ApplicationConfigDTO updateApplicationConfig(ApplicationConfigDTO configDTO) throws ApplicationConfigNotFoundException {
		ApplicationConfig config = configDAO.findOne(configDTO.getId());
		if (config == null) {
			throw new ApplicationConfigNotFoundException(configDTO.getId());
		}
		ApplicationConfig updatedModel = configDAO.update(ApplicationConfigMapper.dtoToModel(configDTO));
		return ApplicationConfigMapper.modelToDto(updatedModel);
	}

	@Override
	public ApplicationConfigDTO getApplicationConfigByName(String name) throws ApplicationConfigNotFoundException {
		try {
			ApplicationConfig config = configDAO.getApplicatonConfigByName(name);
			return ApplicationConfigMapper.modelToDto(config);
		} catch (NoResultException e) {
			throw new ApplicationConfigNotFoundException(name);
		}
	}

	@Override
	public ApplicationConfigDTO getApplicationConfigById(byte id) throws ApplicationConfigNotFoundException {
		ApplicationConfig config = configDAO.findOne(id);
		if (config == null) {
			throw new ApplicationConfigNotFoundException(id);
		}
		return ApplicationConfigMapper.modelToDto(config);
	}

	@Override
	public List<ApplicationConfigDTO> getAllApplicationConfigs() {
		return ApplicationConfigMapper.modelToDtoList(configDAO.findAll());
	}

	@Override
	public List<ApplicationConfigDTO> getApplicationConfigListByPage(int pageNumber, int pageSize) {
		return ApplicationConfigMapper.modelToDtoList(configDAO.getApplicationConfigListByPage(pageNumber, pageSize));
	}

}
