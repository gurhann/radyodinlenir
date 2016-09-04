package com.itaki.radyodinlenir.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public void updateApplicationConfig(ApplicationConfigDTO configDTO) throws ApplicationConfigNotFoundException {
		ApplicationConfig config = configDAO.findOne(configDTO.getId());
		if (config == null) {
			throw new ApplicationConfigNotFoundException(configDTO.getId());
		}
		configDAO.update(ApplicationConfigMapper.dtoToModel(configDTO));
	}


	@Override
	public ApplicationConfigDTO getApplicationConfigById(int id) throws ApplicationConfigNotFoundException {
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
	public List<ApplicationConfigDTO> getApplicationConfigListBySize(int firstIndex, int itemsize) {
		return ApplicationConfigMapper.modelToDtoList(configDAO.getApplicationConfigListByPage(firstIndex, itemsize));
	}

}
